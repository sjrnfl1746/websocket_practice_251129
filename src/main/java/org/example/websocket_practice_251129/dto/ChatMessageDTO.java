package org.example.websocket_practice_251129.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.websocket_practice_251129.domain.enums.ChatType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageDTO {

    private Long id;

    private boolean isDeleted;

    private String name;

    private String message;

    private ChatType chatType;

    private Long chatroomId;
}
