package com.aiProjectBuilder.aiProjectBuilder.repository;

import com.aiProjectBuilder.aiProjectBuilder.entity.ChatEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatEventRepository extends JpaRepository<ChatEvent, Long> {
}
