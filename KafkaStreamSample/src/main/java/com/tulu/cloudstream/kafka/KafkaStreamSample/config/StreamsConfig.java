package com.tulu.cloudstream.kafka.KafkaStreamSample.config;

import com.tulu.cloudstream.kafka.KafkaStreamSample.stream.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {
}
