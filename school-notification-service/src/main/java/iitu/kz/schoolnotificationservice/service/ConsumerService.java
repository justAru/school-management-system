package iitu.kz.schoolnotificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    @KafkaListener(topics = "admin_request", groupId = "group_id")
    public void process(Long id) {
        System.out.println("Notification id = " + id);
    }

}
