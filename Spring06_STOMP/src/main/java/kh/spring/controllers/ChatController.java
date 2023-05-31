package kh.spring.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	@MessageMapping("/message")
	@SendTo("/topic/test")
	public String message(String message, SimpMessageHeaderAccessor smha) {
		String loginID = (String) smha.getSessionAttributes().get("loginID");
		System.out.println("who am i : " + loginID);
		System.out.println(message);
		return message;
	}
}
