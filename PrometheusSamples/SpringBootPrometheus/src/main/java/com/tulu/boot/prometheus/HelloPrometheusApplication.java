package com.tulu.boot.prometheus;

import io.prometheus.client.Counter;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
public class HelloPrometheusApplication {

	private static final Counter requestTotal = Counter.build()
			.name("total_request")
			.labelNames("status")
			.help("A simple Counter to illustrate custom Counters in Spring Boot and Prometheus").register();

	@GetMapping(path = "/hello")
	public @ResponseBody String hello(){
		requestTotal.labels("success").inc();
		return "Hello prometheus";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloPrometheusApplication.class, args);
	}
}
