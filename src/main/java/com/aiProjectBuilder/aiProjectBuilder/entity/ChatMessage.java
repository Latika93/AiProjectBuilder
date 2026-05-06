package com.aiProjectBuilder.aiProjectBuilder.entity;

import com.aiProjectBuilder.aiProjectBuilder.enums.MessageRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    Long id;
    ChatSession chatSession;
    String content;
    String toolCalls; //json array of tools called

    MessageRole messageRole;

    Integer tokenUsed;
    Instant createdAt;
}
