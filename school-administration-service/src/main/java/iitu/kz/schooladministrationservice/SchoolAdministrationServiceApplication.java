package iitu.kz.schooladministrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SchoolAdministrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolAdministrationServiceApplication.class, args);
	}

}
