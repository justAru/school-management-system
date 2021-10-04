package iitu.kz.schoolreportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SchoolReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolReportServiceApplication.class, args);
	}

}
