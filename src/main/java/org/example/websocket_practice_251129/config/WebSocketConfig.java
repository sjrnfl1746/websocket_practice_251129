package org.example.websocket_practice_251129.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Log4j2
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 엔드 포인트 등록
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // stomp 접속 경로 - ws://localhost:8080/ws -> 프로토콜 http X
        registry
                .addEndpoint("/ws") // 엔드 포인트
                .setAllowedOrigins("http://localhost:3000") // 모든 경로로 cors 연결 허용 - 추후 해당하는 경로로만 설정
                .withSockJS();
    }

    // 메시지 브로커 등록
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // 메시지를 수신하는 부분 경로의 엔드 포인트
        registry.enableSimpleBroker("/sub");

        // 메시지를 보내는 부분 경로의 엔드 포인트
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
