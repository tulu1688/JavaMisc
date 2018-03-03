package com.tulu.benchmark.sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

import java.io.IOException;

import static com.tulu.benchmark.sample.utils.HttpClientUtils.httpGetConnect;

/**
 * How to test
 *
 * Run docker petstore docker container
 * docker run -d --name petstore -p 9001:9000 tulu1688/petstore:base
 *
 * Run local petstore service (Springfox test) in localhost
 *
 * Run benchmark:
 *      java -jar target/benchmarks.jar com.tulu.benchmark.sample.ResetServiceInHostAndContainerBenchmark
 */
public class ResetServiceInHostAndContainerBenchmark {
    private static final String URL_LOCAL_HOST = "http://localhost:9000/v1.0/pet/1";
    private static final String URL_DOCKER = "http://localhost:9001/v1.0/pet/1";

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 1, time = 30)
    public static void testLocalHostRestApi() throws IOException {
        httpGetConnect(URL_LOCAL_HOST);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 1, time = 30)
    public static void testDockerContainerRestApi() throws IOException {
        httpGetConnect(URL_DOCKER);
    }
}
