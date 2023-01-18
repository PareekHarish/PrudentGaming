package com.PrudentGaming.KafkaIntegration;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    
    @KafkaListener(topics = "bet_detail", groupId = "bet_detail")
    public void consumeFromTopic(String message) {
        System.out.println("Consumed Message is " + message);
    }
}
