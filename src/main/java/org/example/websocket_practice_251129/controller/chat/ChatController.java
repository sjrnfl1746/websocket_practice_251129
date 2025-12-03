package org.example.websocket_practice_251129.controller.chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.websocket_practice_251129.dto.ChatMessageDTO;
import org.example.websocket_practice_251129.service.chatMessage.ChatMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations template;
    private final ChatMessageService chatMessageService;

    // 메시지 송수신
    @MessageMapping("/message")
    public ChatMessageDTO receiveMessage(ChatMessageDTO chatMessageDTO) {

        // 들어온 메시지
        log.info("들어온 메시지: {}", chatMessageDTO);

        // 받은 메시지를 db에 저장
        chatMessageService.addMessage(chatMessageDTO);

        // chatroomId 추출
        Long chatroomId = chatMessageDTO.getChatroomId();

        // 메시지를 해당 채팅방 구독자들에게 전송
        template.convertAndSend("/sub/messages/" + chatroomId, chatMessageDTO);

        log.info("전송할 메시지: {}", chatMessageDTO);

        return chatMessageDTO;
    }

    @MessageMapping("/send")
    @SendTo("/sub/messages")
    public String sendMessage(String inputMessage) {
        log.info("메시지 들어옴: {}", inputMessage);

        return inputMessage;
    }


}
