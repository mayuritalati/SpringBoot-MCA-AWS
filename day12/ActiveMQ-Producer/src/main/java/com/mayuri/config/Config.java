package com.mayuri.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;


@Configuration
public class Config {
	
	
	@org.springframework.beans.factory.annotation.Value("${activemq.broker-url}")
	String brokerURL;

	@Bean
	ActiveMQConnectionFactory activeMQConnectionFactory(){
		return new ActiveMQConnectionFactory(brokerURL);
	}
	
	@Bean
	JmsTemplate JmsTemplate(){
		return new JmsTemplate(activeMQConnectionFactory());
	}

	@Bean
	public Queue queue(){
		return new ActiveMQQueue("activemq.queue");
	}
}
