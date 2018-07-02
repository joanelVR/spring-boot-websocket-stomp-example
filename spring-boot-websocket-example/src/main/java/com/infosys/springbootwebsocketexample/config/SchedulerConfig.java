package com.infosys.springbootwebsocketexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.infosys.springbootwebsocketexample.model.UserResponse;

//Will push the messages into the same user topic
@Configuration
@EnableScheduling
public class SchedulerConfig {

	//Triggers the message to be send to the same topic (/topic/user)
	@Autowired
	SimpMessagingTemplate template;
	
	@Scheduled(fixedDelay = 3000) //Calls this method every 3 seconds
	public void sendAdhocMessages() {
		//Sends the payload (new UserResponse) to the topic (/topic/user)
		template.convertAndSend("/topic/user", new UserResponse("Fixed Delay Scheduler"));
	}
}
