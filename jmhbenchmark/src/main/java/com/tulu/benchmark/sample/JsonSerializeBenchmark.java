package com.tulu.benchmark.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

public class JsonSerializeBenchmark {
    public class Car {
        private String color;
        private String type;

        public Car(String color, String type) {
            this.color = color;
            this.type = type;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void jacksonSerialize(){
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");
        try {
            String strObj = objectMapper.writeValueAsString(car);
            assert strObj.equals("{\"color\":\"yellow\",\"type\":\"renault\"}");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void gsonSerialize(){
        Car car = new Car("yellow", "renault");
        Gson gson = new Gson();
        String strObj = gson.toJson(car);
        assert strObj.equals("{\"color\":\"yellow\",\"type\":\"renault\"}");
    }
}
