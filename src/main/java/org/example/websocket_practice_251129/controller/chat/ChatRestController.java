package org.example.websocket_practice_251129.controller.chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.websocket_practice_251129.dto.ChatMessageDTO;
import org.example.websocket_practice_251129.service.chatMessage.ChatMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatRestController { // 채팅 관련 송수신 외의 기능들

    private final ChatMessageService chatMessageService;

    // 메시지 삭제 - isDeleted를 true로 변경(update 방식)
    @PostMapping("/remove/{id}")
    public String removeChatMessage(@PathVariable Long id) {

        chatMessageService.updateMessage(id);

        return "REMOVE MESSAGE SUCCESS";
    }

    // 채팅 메시지 반환 - chatrommId 값으로 해당하는 메시지들 전체 반환 - (수정) 채팅방 접속 시간을 받은 후 접속 시간 이후에 저장된 메시지만 반환
    @GetMapping("/{id}")
    public ResponseEntity<List<ChatMessageDTO>> getChatMessages(@PathVariable Long id) {

        List<ChatMessageDTO> chatMessageDTOList = chatMessageService.getAllMessages(id);

        for (ChatMessageDTO chatMessageDTO : chatMessageDTOList) {
            log.info("반환받은 메시지: {}", chatMessageDTO);
        }

        return ResponseEntity.ok(chatMessageDTOList);
    }
}
