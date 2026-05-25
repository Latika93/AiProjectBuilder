package com.aiProjectBuilder.aiProjectBuilder.dto.chat;

import com.aiProjectBuilder.aiProjectBuilder.entity.ChatEvent;
import com.aiProjectBuilder.aiProjectBuilder.entity.ChatSession;
import com.aiProjectBuilder.aiProjectBuilder.enums.MessageRole;

import java.time.Instant;
import java.util.List;

public record ChatResponse(
        Long id,
        ChatSession chatSession,
        MessageRole role,
        List<ChatEvent> events,
        String content,
        Integer tokensUsed,
        Instant createdAt

) {
}
