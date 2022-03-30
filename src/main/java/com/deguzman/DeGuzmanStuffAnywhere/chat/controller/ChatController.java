package com.deguzman.DeGuzmanStuffAnywhere.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.chat.model.Message;

@RestController
public class ChatController {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public Message sendMessage(@Payload Message message) {
		return message;
	}
	
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public Message adduser(@Payload Message message,
			SimpMessageHeaderAccessor headerAccessor) {
		
		headerAccessor.getSessionAttributes().put("username", message.getSender());
		
		return message;
	}
}