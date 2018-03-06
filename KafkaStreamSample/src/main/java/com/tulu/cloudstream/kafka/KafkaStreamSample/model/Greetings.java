package com.tulu.cloudstream.kafka.KafkaStreamSample.model;

public class Greetings {
    private long timestamp;
    private String message;

    public Greetings() {
    }

    public Greetings(String msg, long timestamp) {
        this.message = msg;
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greetings{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }

    public static GreetingsBuilder builder() {
        return new GreetingsBuilder();
    }

    public static class GreetingsBuilder {
        private String msg;
        private long timestamp;

        public GreetingsBuilder message(String message){
            this.msg = message;
            return this;
        }

        public GreetingsBuilder timestamp(long timestamp){
            this.timestamp = timestamp;
            return this;
        }

        public Greetings build(){
            return new Greetings(this.msg, this.timestamp);
        }
    }
}
