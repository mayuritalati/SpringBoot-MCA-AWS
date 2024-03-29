package com.techprimers.messaging.inmemoryactivemqexample.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.validation.Valid;

@EnableJms
@Configuration
public class Config {
	
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("inmemory.queue");
    }
}
