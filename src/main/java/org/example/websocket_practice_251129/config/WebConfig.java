package org.example.websocket_practice_251129.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /********** cors 설정 **********/

    // 프론트 연결 주소 port: 3000
    private static final String DEVELOP_FRONT_ADDRESS = "http://localhost:3000";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(DEVELOP_FRONT_ADDRESS)
                .allowedMethods("GET", "POST", "PUT", "DELETE")

                // 프론트에서 헤드 읽을 수 있게 설정
                .exposedHeaders("location")
                .allowedHeaders("*")

                // WebSocket + JWT 인증을 할 떄 반드시 필요 - Authorization 헤더를 서버에 보내려면 필요
                .allowCredentials(true);
    }
}
