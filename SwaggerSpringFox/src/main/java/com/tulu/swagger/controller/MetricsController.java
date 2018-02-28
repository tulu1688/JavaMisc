package com.tulu.swagger.controller;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.common.TextFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

@RestController
@RequestMapping(value = "/v1.0")
public class MetricsController {
    @RequestMapping(value = "/metrics", method = RequestMethod.GET)
    public ResponseEntity<StreamingResponseBody> getMetrics() {

        System.out.println("Get all metrics info");
        StreamingResponseBody responseBody = outputStream -> {
            Writer writer = new OutputStreamWriter(outputStream);
            TextFormat.write004(writer, CollectorRegistry.defaultRegistry.metricFamilySamples());
            System.out.println("hey man. Im running");
        };

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
