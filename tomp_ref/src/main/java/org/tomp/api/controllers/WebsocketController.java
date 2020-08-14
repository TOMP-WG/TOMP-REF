package org.tomp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class WebsocketController {

	@Autowired
	ObjectMapper mapper;

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	public void sendMessage(String message, Object o) {
		try {
			if (o == null) {
				simpMessagingTemplate.convertAndSend("/topic/backend", message + "\r\n");
			} else {
				simpMessagingTemplate.convertAndSend("/topic/backend",
						message + "\r\n" + mapper.writeValueAsString(o) + "\r\n");
			}
		} catch (MessagingException | JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
