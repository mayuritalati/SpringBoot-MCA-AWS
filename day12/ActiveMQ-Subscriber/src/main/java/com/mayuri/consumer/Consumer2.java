package com.mayuri.consumer;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {
	
	@JmsListener(destination="activemq.topic")
	public void consumeMsg(Message message){
		System.out.println("Consumer2::::::::");
		System.out.println(message.toString());
	}

}
