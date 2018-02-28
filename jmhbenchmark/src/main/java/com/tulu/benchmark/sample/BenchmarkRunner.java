package com.tulu.benchmark.sample;

/**
 * Can run benchmark for jar file follow command
 *   java -jar target/benchmarks.jar -f 2 -wi 3 -i 2
 *      -f: fork
 *      -wi: warmup iteration
 *      -i: iteration
 */
public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}