package iitu.kz.schoolnotificationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@ComponentScan("iitu.kz.schoolnotificationservice")
public class MailConfig {
//    @Bean
//    public JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        // TODO mailsender fill config
//        return mailSender;
//    }
}
