package org.example.websocket_practice_251129.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.websocket_practice_251129.domain.enums.ChatType;

import java.time.LocalDateTime;

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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
