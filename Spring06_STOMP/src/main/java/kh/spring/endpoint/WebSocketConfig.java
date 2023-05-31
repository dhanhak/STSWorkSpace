package kh.spring.endpoint;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		// 구독할 수 있는 Endpoint URL의 prefix [ Server -> Client ]  
		config.setApplicationDestinationPrefixes("/app");	
		// 클라이언트가 메세지를 보낼 때 사용할 URL의 prefix [ Client -> Server ]
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat")
		.addInterceptors(new HttpSessionHandshakeInterceptor()) // modifiyhandshake 할수있게 해주는 작업
		.setAllowedOrigins("*");
	}


	
}
