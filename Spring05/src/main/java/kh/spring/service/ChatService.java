package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.repositories.ChatDAO;

@Service
public class ChatService {

	@Autowired
	private ChatDAO dao;
}
