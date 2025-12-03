package org.example.websocket_practice_251129.repository;

import org.example.websocket_practice_251129.domain.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    public List<ChatMessage> findAllByChatroomId(Long chatroomId);
}
