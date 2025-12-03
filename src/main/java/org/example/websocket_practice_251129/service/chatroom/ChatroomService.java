package org.example.websocket_practice_251129.service.chatroom;

import org.example.websocket_practice_251129.dto.ChatroomDTO;

import java.util.List;

public interface ChatroomService {

    // 모든 채팅룸 조회
    List<ChatroomDTO> getAllChatrooms();
}
