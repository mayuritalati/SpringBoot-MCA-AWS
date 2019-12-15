package com.mayuri.config;

import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
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
	public Topic queue(){
		return new ActiveMQTopic("activemq.topic");
	}
}
