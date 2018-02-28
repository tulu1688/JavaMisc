# Create test project command
mvn archetype:generate -DinteractiveMode=false -DarchetypeGroupId=org.openjdk.jmh \
      -DarchetypeArtifactId=jmh-java-benchmark-archetype -DarchetypeVersion=1.4.1 \
      -DgroupId=org.agoncal.sample.jmh -DartifactId=logging -Dversion=1.0
      
# Run benchmark after build jar file with default config
java -jar target/benchmarks.jar

# Run benchmark with config
java -jar target/benchmarks.jar -f 2 -wi 3 -i 2
-f: fork
-wi: warmup iteration
-i: iteration

# Annotation based config
```
@Fork(1)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class InfinityDBJMHTest {
…
}
```

# Some related article
- [Micro benchmark logging with JMH](https://antoniogoncalves.org/2015/01/15/micro-benchmarking-with-jmh-measure-dont-guess/)
- [Testing InfitnityDb with JMH](https://dzone.com/articles/jmh-performance-testing-infinitydb)