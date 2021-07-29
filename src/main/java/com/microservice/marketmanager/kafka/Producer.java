package com.microservice.marketmanager.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    public static final String topic = "projectTopic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemp;


    public void publishToTopic(String msg) {
        System.out.println("pong");
        this.kafkaTemp.send(topic, msg);
    }
}