package org.example.websocket_practice_251129.service.chatroom;

import lombok.extern.log4j.Log4j2;
import org.example.websocket_practice_251129.dto.ChatroomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ChatroomServiceTest {

    @Autowired
    private ChatroomService chatroomService;

    @Test
    void getAllChatrooms() {

        List<ChatroomDTO> allChatrooms = chatroomService.getAllChatrooms();

        for (ChatroomDTO chatroomDTO : allChatrooms) {
            log.info(chatroomDTO);
        }

    }

}