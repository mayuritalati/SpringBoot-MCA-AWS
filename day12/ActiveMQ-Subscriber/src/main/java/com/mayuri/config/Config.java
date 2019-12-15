package com.mayuri.config;

import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
	
	
	@org.springframework.beans.factory.annotation.Value("${activemq.broker-url}")
	String brokerURL;

	@Bean
	ActiveMQConnectionFactory activeMQConnectionFactory(){
		return new ActiveMQConnectionFactory(brokerURL);
	}

	@Bean
	public Topic queue(){
		return new ActiveMQTopic("activemq.topic");
	}
	
	
}
