package com.tulu.benchmark.sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

import java.util.HashMap;

public class HelloBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public void testSimpleCreateHashmap() {
        HashMap<String,String> myHashMap = new HashMap<>();
        String key = "key_" + System.currentTimeMillis();
        String tuluKey = myHashMap.get(key);
        if (tuluKey == null)
            myHashMap.put(key,"value_" + key);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public void testCreateIfAbsentHashmapItem() {
        HashMap<String,String> myHashMap = new HashMap<>();
        String key = "key_" + System.currentTimeMillis();
        myHashMap.computeIfAbsent(key, k -> "value_" + k);
    }
}
