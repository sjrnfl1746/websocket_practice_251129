package org.example.websocket_practice_251129.repository.queryDSL;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.websocket_practice_251129.domain.ChatMessage;
import org.example.websocket_practice_251129.domain.QChatMessage;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChatMessageRepositoryCustomImpl implements ChatMessageRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    QChatMessage chatMessage = QChatMessage.chatMessage;

    @Override
    public List<ChatMessage> findAllByChatroomIdAndEnterTime(Long chatroomId, LocalDateTime enterTime) {

        return queryFactory
                .selectFrom(chatMessage)
                .where(chatMessage.chatroom.id.eq(chatroomId)
                        .and(chatMessage.createdAt.after(enterTime))
                )
                .orderBy(chatMessage.createdAt.asc())
                .fetch();
    }
}
