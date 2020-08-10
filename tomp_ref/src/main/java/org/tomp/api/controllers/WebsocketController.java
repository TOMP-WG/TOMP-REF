package org.tomp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Controller
public class WebsocketController {

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	public WebsocketController() {
		this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	public void sendMessage(String message, Object o) {
		try {
			if (o == null) {
				simpMessagingTemplate.convertAndSend("/topic/backend", message);
			} else {
				simpMessagingTemplate.convertAndSend("/topic/backend", message + "\r\n" + mapper.writeValueAsString(o));
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
