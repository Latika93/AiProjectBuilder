package com.aiProjectBuilder.aiProjectBuilder.repository;

import com.aiProjectBuilder.aiProjectBuilder.entity.ChatSession;
import com.aiProjectBuilder.aiProjectBuilder.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}
