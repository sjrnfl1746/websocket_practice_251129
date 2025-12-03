package org.example.websocket_practice_251129;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WebsocketPractice251129Application {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketPractice251129Application.class, args);
    }

}
