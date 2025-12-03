package org.example.websocket_practice_251129.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.websocket_practice_251129.dto.ChatroomDTO;
import org.example.websocket_practice_251129.service.chatroom.ChatroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/chatroom")
public class ChatroomController {

    private final ChatroomService chatroomService;

    // 전체 채팅방 조회
    @GetMapping("/list")
    public ResponseEntity<List<ChatroomDTO>> list() {

        List<ChatroomDTO> chatroomDTOList = chatroomService.getAllChatrooms();

        for (ChatroomDTO chatroomDTO : chatroomDTOList) {
            log.info("채팅방: {}", chatroomDTO);
        }

        return ResponseEntity.ok(chatroomDTOList);
    }
}
