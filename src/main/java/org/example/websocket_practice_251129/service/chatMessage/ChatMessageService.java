package org.example.websocket_practice_251129.service.chatMessage;

import org.example.websocket_practice_251129.dto.ChatMessageDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ChatMessageService {

    // 채팅 입력
    void addMessage(ChatMessageDTO chatMessageDTO);

    // 채팅 삭제 - isDeleted를 true로 변경
    void updateMessage(Long id);

    // chatroom_id로 전체 메시지 가져오기
    List<ChatMessageDTO> getAllMessages(Long chatroomId);
}
