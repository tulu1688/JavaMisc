package com.tulu.benchmark.sample.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class HttpClientUtils {
    public static String httpPostConnect(String url) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            return getStringFromInputStream(entity.getContent());
        }
        return null;
    }

    public static String httpGetConnect(String url) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        HttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            return getStringFromInputStream(entity.getContent());
        }
        return null;
    }

    private static String getStringFromInputStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] buf = new byte[1024];
            int length;

            while ((length = is.read(buf)) != -1) {
                sb.append(new String(buf, 0, length));
            }
        } finally {
            is.close();
        }

        return sb.toString();
    }
}
