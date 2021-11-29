package iitu.kz.schooladministrationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final String TOPIC = "admin_request";

    @Autowired
    private KafkaTemplate<String, Long> kafkaTemplate;

    public String sendMessage(Long id) {
        System.out.println(String.format("#### -> sending message -> %s", id));
        this.kafkaTemplate.send(TOPIC, id);
        return "success";
    }
}
