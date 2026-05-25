package com.aiProjectBuilder.aiProjectBuilder.mapper;

import com.aiProjectBuilder.aiProjectBuilder.dto.chat.ChatResponse;
import com.aiProjectBuilder.aiProjectBuilder.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}
