package com.tulu.cloudstream.kafka.KafkaStreamSample.service;

import com.tulu.cloudstream.kafka.KafkaStreamSample.model.Greetings;
import com.tulu.cloudstream.kafka.KafkaStreamSample.stream.GreetingsStreams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class GreetingsListener {
    Logger logger = LogManager.getLogger(GreetingsListener.class);

    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
        logger.info("Received greetings: {}", greetings);
    }
}
