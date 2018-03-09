package com.tulu.micrometer.HelloMicrometer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class HelloMicrometerApplication {


	private Counter hellos = Metrics.counter("hellos");

	@GetMapping(path = "/hello")
	public @ResponseBody String sayHi(){
		hellos.increment();
		return "hi micrometer";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloMicrometerApplication.class, args);
	}
}
