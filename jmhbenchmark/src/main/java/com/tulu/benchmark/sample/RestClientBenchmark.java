package com.tulu.benchmark.sample;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

import java.io.IOException;
import java.io.InputStream;

public class RestClientBenchmark {
    private static final String URL = "http://localhost:8094/report/v3.1/customers/summaries/sofs/cash";

    /**
     * Run benchmark without warmup
     * Measure for 3 minutes each fork
     */
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 0)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1, time = 180)
    public static void testCallRestApi() throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(URL);

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream is = entity.getContent();
            try {
                byte[] buf = new byte[1024];
                int length;
                StringBuilder stringBuilder = new StringBuilder();

                while ((length = is.read(buf)) != -1) {
                    stringBuilder.append(new String(buf, 0, length));
                }
                System.out.println(stringBuilder.toString());
            } finally {
                is.close();
            }
        }
    }
}
