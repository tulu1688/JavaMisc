package com.tulu.mockserver;

import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.TimeToLive;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import java.util.concurrent.TimeUnit;

import static org.mockserver.integration.ClientAndProxy.startClientAndProxy;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

/**
 * Mockserver documentation
 *
 * http://www.mock-server.com/
 */
public class HelloMockServer {
    private static ClientAndServer mockServer;
    private static ClientAndProxy proxy;

    public static void main(String[] args) {
        mockServer = startClientAndServer(1080);
        proxy = startClientAndProxy(1090);

        mockServer.when(
                HttpRequest.request()
                        .withPath("/hello/mockserver")
                        .withMethod("POST"),
                Times.unlimited(),
                TimeToLive.exactly(TimeUnit.HOURS,1L)
        ).respond(
                HttpResponse.response().withBody("\"{\"status\":{\"code\":\"success\",\"message\":\"Success\"},\"data\":null}\"")
        );

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void start(){
                System.out.println("Bye bye mockserver");
                mockServer.stop();
            }
        });
    }
}
