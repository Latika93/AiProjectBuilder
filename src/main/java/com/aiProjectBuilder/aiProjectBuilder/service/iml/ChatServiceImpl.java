package com.aiProjectBuilder.aiProjectBuilder.service.iml;

import com.aiProjectBuilder.aiProjectBuilder.dto.chat.ChatResponse;
import com.aiProjectBuilder.aiProjectBuilder.entity.ChatMessage;
import com.aiProjectBuilder.aiProjectBuilder.entity.ChatSession;
import com.aiProjectBuilder.aiProjectBuilder.entity.ChatSessionId;
import com.aiProjectBuilder.aiProjectBuilder.mapper.ChatMapper;
import com.aiProjectBuilder.aiProjectBuilder.repository.ChatMessageRepository;
import com.aiProjectBuilder.aiProjectBuilder.repository.ChatSessionRepository;
import com.aiProjectBuilder.aiProjectBuilder.security.AuthUtil;
import com.aiProjectBuilder.aiProjectBuilder.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatSessionRepository chatSessionRepository;
    private final AuthUtil authUtil;
    private final ChatMapper chatMapper;

    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        ChatSession chatSession = chatSessionRepository.getReferenceById(
                new ChatSessionId(projectId, userId)
        );

        List<ChatMessage> chatMessageList = chatMessageRepository.findByChatSession(chatSession);

        return chatMapper.fromListOfChatMessage(chatMessageList);
    }
}