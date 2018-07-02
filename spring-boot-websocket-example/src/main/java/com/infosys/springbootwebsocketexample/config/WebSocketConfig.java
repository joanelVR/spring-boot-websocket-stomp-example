package com.infosys.springbootwebsocketexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
@SuppressWarnings("deprecation")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	//Method that needs to be implemented in order to provide needed element for webSocket
	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		//This is where the websocket will be created.
		//If creating multiple websocket, add them here.
		stompEndpointRegistry.addEndpoint("/websocket-example")
			.withSockJS(); //Library by which we will create the web socket. 
	}
	
	//We need to add some broker information for the message
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		
		//Where we will pushing the messages. Needs to be enabled
		registry.enableSimpleBroker("/topic");
		//The prefix for the destination will be /app + whatever the websocket part we provide 
		registry.setApplicationDestinationPrefixes("/app");
	}
	
}
