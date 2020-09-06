package com.pinku.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.pinku.kafka.model.User;

@Configuration
public class KafkaConfiguration {
	
	
	@Bean
	public ProducerFactory<String, User> producerFactory(){
		
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<String, User>(config);
	}
	
	@Bean
	public KafkaTemplate<String, User> kafkaTemplate(){
		
		return new KafkaTemplate<String, User>(producerFactory());
	}

}
