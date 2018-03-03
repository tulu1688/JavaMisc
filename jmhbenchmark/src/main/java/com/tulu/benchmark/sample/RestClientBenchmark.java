package com.tulu.benchmark.sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

import java.io.IOException;

import static com.tulu.benchmark.sample.utils.HttpClientUtils.httpPostConnect;

public class RestClientBenchmark {
    private static final String URL = "http://sample.com/";

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
        httpPostConnect(URL);
    }
}
