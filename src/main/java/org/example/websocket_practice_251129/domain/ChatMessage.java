package org.example.websocket_practice_251129.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.websocket_practice_251129.domain.common.BaseEntity;
import org.example.websocket_practice_251129.domain.enums.ChatType;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ChatMessage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_deleted")
    private boolean isDeleted; // 채팅 삭제 여부

    private String name; // 작성자 이름

    private String message; // 메시지 내용

    @Enumerated(EnumType.STRING)
    @Column(name = "chat_type")
    private ChatType chatType; // 채팅 타입 - ENTER, LEAVE, CHAT

    @ManyToOne
    @JoinColumn(name = "chatroom_id")
    private Chatroom chatroom; // fk 설정 - chatroom_id

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public void changeIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
