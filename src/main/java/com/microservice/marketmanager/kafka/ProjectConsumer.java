package com.microservice.marketmanager.kafka;

import com.microservice.marketmanager.project.Project;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectConsumer {

    @KafkaListener(topics="projectTopic", groupId ="microservice")
    public void consumeFromTopic(String info) {
        System.out.println(info);
    }
}


