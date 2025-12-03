package org.example.websocket_practice_251129.repository;

import org.example.websocket_practice_251129.domain.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatroomRepository extends JpaRepository<Chatroom, Long> {
}
