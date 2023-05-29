package kh.spring.config;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class HttpSessionConfigurator extends Configurator {

	@Override // 초기화 과정
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		HttpSession session = (HttpSession)request.getHttpSession();	// WebSocket 연결 과정에 포함된 HttpSession을 획득
		sec.getUserProperties().put("hSession", session);				// WebSocket으로 전달되는 데이터 맵 안에 HttpSession을 첨부
		
	}

}
