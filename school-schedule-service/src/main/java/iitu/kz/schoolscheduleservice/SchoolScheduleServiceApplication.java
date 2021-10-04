package iitu.kz.schoolscheduleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SchoolScheduleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolScheduleServiceApplication.class, args);
	}

}
