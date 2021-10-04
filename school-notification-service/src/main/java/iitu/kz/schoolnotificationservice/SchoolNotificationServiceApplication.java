package iitu.kz.schoolnotificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SchoolNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolNotificationServiceApplication.class, args);
	}

}
