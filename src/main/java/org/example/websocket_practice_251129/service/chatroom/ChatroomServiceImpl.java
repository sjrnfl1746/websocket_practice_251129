package org.example.websocket_practice_251129.service.chatroom;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.websocket_practice_251129.domain.Chatroom;
import org.example.websocket_practice_251129.dto.ChatroomDTO;
import org.example.websocket_practice_251129.repository.ChatroomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ChatroomServiceImpl implements ChatroomService {

    private final ChatroomRepository chatroomRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ChatroomDTO> getAllChatrooms() {

        List<ChatroomDTO> chatroomDTOList = new ArrayList<>();

        List<Chatroom> chatroomList = chatroomRepository.findAll();

        for (Chatroom chatroom : chatroomList) {
            ChatroomDTO chatroomDTO = modelMapper.map(chatroom, ChatroomDTO.class);

            chatroomDTOList.add(chatroomDTO);
        }

        return chatroomDTOList;
    }
}
