package com.PrudentGaming.KafkaIntegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTopic {
    
    public static final String topic = "bet_detail";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemp;

    public void sendMessage(String message) {
        kafkaTemp.send(topic, message);
        kafkaTemp.destroy();
    }
}
