package org.example.websocket_practice_251129.repository.queryDSL;

import org.example.websocket_practice_251129.domain.ChatMessage;

import java.time.LocalDateTime;
import java.util.List;

public interface ChatMessageRepositoryCustom {

    // id, enterTime 받아서 메시지 반환
    public List<ChatMessage> findAllByChatroomIdAndEnterTime(Long chatroomId, LocalDateTime enterTime);
}
