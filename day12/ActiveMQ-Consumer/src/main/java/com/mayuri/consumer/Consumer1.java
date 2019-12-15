package com.mayuri.consumer;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {
	
	@JmsListener(destination="activemq.queue")
	public void consumeMsg(Message message){
		System.out.println("Consumer1::::::::");
		System.out.println(message.toString());
	}

}
