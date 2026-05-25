package com.aiProjectBuilder.aiProjectBuilder.dto.chat;

import com.aiProjectBuilder.aiProjectBuilder.enums.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatEventType type,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata
) {
}