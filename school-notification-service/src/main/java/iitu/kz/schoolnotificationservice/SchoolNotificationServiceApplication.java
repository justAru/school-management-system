package iitu.kz.schoolnotificationservice;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "iitu.kz")
@EnableHystrixDashboard
@EnableHystrix
@EnableCircuitBreaker
@EnableScheduling
public class SchoolNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolNotificationServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "json");

		return props;
	}

	@Bean
	public ConsumerFactory<String, Long> consumerFactory() {
		JsonDeserializer<Long> deserializer = new JsonDeserializer<>(Long.class);
//		deserializer.setRemoveTypeHeaders(false);
		deserializer.addTrustedPackages("*");
		deserializer.setUseTypeMapperForKey(true);

		return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
				deserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Long> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Long> factory =
				new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());

		return factory;
	}
}
