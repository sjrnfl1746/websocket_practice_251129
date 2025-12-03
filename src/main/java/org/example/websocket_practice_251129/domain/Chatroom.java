package org.example.websocket_practice_251129.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.websocket_practice_251129.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Chatroom extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_name")
    private String roomName; // 채팅방 이름

    @Builder.Default
    @OneToMany(mappedBy = "chatroom", cascade = CascadeType.PERSIST)
    private List<ChatMessage> chatMessages = new ArrayList<>();
}
