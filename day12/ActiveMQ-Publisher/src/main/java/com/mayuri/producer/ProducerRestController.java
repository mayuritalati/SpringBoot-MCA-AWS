package com.mayuri.producer;

import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("0.1/rest/producer")
public class ProducerRestController {

	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	Topic topic;
	
	@GetMapping("/{message}")
	public String  produceMsg(@PathVariable("message") String message){
		jmsTemplate.convertAndSend(topic, message);
		
		System.out.println("message Published sucefully");
		return "message Published sucefully";
	}
}
