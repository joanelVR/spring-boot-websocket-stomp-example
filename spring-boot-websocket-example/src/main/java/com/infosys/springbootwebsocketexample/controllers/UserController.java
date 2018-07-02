package com.infosys.springbootwebsocketexample.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.infosys.springbootwebsocketexample.model.User;
import com.infosys.springbootwebsocketexample.model.UserResponse;

@Controller
public class UserController {

	@MessageMapping("/user")
                            // User STOMP (Simple Text Oriented Messaging Protocol)
	@SendTo("/topic/user")  // Pushes the message (or user) into the user topic
	public UserResponse getUser(User user) {
		
		return new UserResponse("Hi " + user.getName());
	}
}
