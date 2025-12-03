package org.example.websocket_practice_251129.service.chatMessage;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.websocket_practice_251129.domain.ChatMessage;
import org.example.websocket_practice_251129.domain.Chatroom;
import org.example.websocket_practice_251129.dto.ChatMessageDTO;
import org.example.websocket_practice_251129.repository.ChatMessageRepository;
import org.example.websocket_practice_251129.repository.ChatroomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatroomRepository chatroomRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addMessage(ChatMessageDTO chatMessageDTO) {

        ChatMessage chatMessage = modelMapper.map(chatMessageDTO, ChatMessage.class);

        // 채팅방 조회
        Chatroom chatroom = chatroomRepository.findById(chatMessageDTO.getChatroomId())
                .orElseThrow(() -> new EntityNotFoundException("해당하는 채팅방을 찾을 수 없습니다."));

        // 메시지 부분에 채팅방 세팅
        chatMessage.setChatroom(chatroom);

        chatMessageRepository.save(chatMessage);
    }

    @Override
    public void updateMessage(Long id) {
        ChatMessage chatMessage = chatMessageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 메시지를 찾을 수 없습니다."));
        chatMessage.changeIsDeleted(true);

        chatMessageRepository.save(chatMessage);
    }

    @Override
    public List<ChatMessageDTO> getAllMessages(Long chatroomId) {

        List<ChatMessageDTO> chatMessageDTOList = new ArrayList<>();

        List<ChatMessage> chatMessageList = chatMessageRepository.findAllByChatroomId(chatroomId);

        for (ChatMessage chatMessage : chatMessageList) {
            ChatMessageDTO chatMessageDTO = modelMapper.map(chatMessage, ChatMessageDTO.class);

            // 해당하는 chatroomId를 직접 세팅
            chatMessageDTO.setChatroomId(chatMessage.getChatroom().getId());
            chatMessageDTOList.add(chatMessageDTO);
        }

        return chatMessageDTOList;
    }
}
