package com.pinku.kafka.controller;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserController {

	private static final String TOPIC = "test";
	
	@Autowired
	KafkaTemplate<String, com.pinku.kafka.model.User> kafkaTemplate;
	
	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name) {
	
		kafkaTemplate.send(TOPIC, new com.pinku.kafka.model.User(name, "E Block", 120000L));
		
		return "Message publish successfully";
	}
}
