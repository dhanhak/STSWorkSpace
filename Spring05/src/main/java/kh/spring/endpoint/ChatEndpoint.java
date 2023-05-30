package kh.spring.endpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.common.collect.EvictingQueue;

import kh.spring.config.HttpSessionConfigurator;

@ServerEndpoint(value = "/chat", configurator = HttpSessionConfigurator.class)
public class ChatEndpoint {

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());
	private HttpSession hSession;
	
	private static EvictingQueue<String> messages = EvictingQueue.create(100);
	
	@OnOpen
	public void onConnect(Session session, EndpointConfig config) {
		ChatEndpoint.clients.add(session);
		this.hSession = (HttpSession) config.getUserProperties().get("hSession");
	}

	@OnMessage
	public void onMessage(String message) {

		String id = (String) hSession.getAttribute("loginID");
		
		synchronized (clients) {	// 동기화 블럭 // 동시성
			for (Session session : clients) {
				try {
					session.getBasicRemote().sendText(id + " : " + message);
				} catch (IOException e) {}
			}
		}
	}

	@OnClose
	public void onClose(Session s) {
		System.out.println("웹 소켓 연결 해제");
		clients.remove(s);
	}

	@OnError
	public void onError(Session s, Throwable t) {
		System.out.println("웹 소켓 통신 오류");
		clients.remove(s);
	}

}
