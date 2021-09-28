package iitu.kz.schoolnotificationservice.service.impl;

import iitu.kz.schoolnotificationservice.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Override
    public String notificateUser(Long id) {
        System.out.println("NotificationServiceImpl.notificateUser");
        return "hello!";
    }
}
