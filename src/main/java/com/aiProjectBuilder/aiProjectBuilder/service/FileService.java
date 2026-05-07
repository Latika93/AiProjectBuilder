package com.aiProjectBuilder.aiProjectBuilder.service;

import com.aiProjectBuilder.aiProjectBuilder.dto.project.FileContentResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long id, Long userId);

    FileContentResponse getFile(Long projectId, String path);
}
