package org.example.websocket_practice_251129.service.chatMessage;

import lombok.extern.log4j.Log4j2;
import org.example.websocket_practice_251129.dto.ChatMessageDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ChatMessageServiceTest {

    @Autowired
    private ChatMessageService chatMessageService;

    @Test
    void addMessage() {

        for (int i = 0; i < 10; i++) {
            Long chatroomId = 1L;

            ChatMessageDTO chatMessageDTO = ChatMessageDTO.builder()
                    .isDeleted(false)
                    .name("user" + i)
                    .message("message" + i)
                    .chatroomId(chatroomId)
                    .build();

            chatMessageService.addMessage(chatMessageDTO);
        }
    }

    @Test
    void updateMessage() {
        Long id = 49L;

        chatMessageService.updateMessage(id);
    }

    @Test
    void getAllMessages() {
        Long id = 1L;

        LocalDateTime enterTime = LocalDateTime.now();

        List<ChatMessageDTO> chatMessageDTOList = chatMessageService.getAllMessages(id, enterTime);

        for (ChatMessageDTO chatMessageDTO : chatMessageDTOList) {
            log.info(chatMessageDTO.toString());
        }
    }
}