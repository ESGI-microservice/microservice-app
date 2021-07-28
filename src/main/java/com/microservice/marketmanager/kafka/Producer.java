package com.microservice.marketmanager.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    public static final String topic = "projectTopic";

    @Autowired
    private KafkaTemplate<String, Long> kafkaTemp;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemp2;

    public void publishToTopic(Long id) {
        this.kafkaTemp.send(topic, id);
    }

    public void publishToTopic(String msg) {
        this.kafkaTemp2.send(topic, msg);
    }
}

