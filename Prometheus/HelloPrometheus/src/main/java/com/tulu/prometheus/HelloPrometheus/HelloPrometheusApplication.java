package com.tulu.prometheus.HelloPrometheus;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.exporter.common.TextFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.Writer;

@Controller
@SpringBootApplication
public class HelloPrometheusApplication {
	Logger log = LogManager.getLogger(HelloPrometheusApplication.class);

	private final Counter counter = Counter.build()
			.name("request_total")
			.help("Total number of request")
			.register();

	@GetMapping(path = "/hello")
	public @ResponseBody String hello(){
		counter.inc();
		return "Hello prometheus";
	}

	@GetMapping(path = "/metrics")
	public void metrics(Writer responseWriter) throws IOException{
		TextFormat.write004(responseWriter, CollectorRegistry.defaultRegistry.metricFamilySamples());
		responseWriter.close();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloPrometheusApplication.class, args);
	}
}
