package com.aiProjectBuilder.aiProjectBuilder.service.iml;

import com.aiProjectBuilder.aiProjectBuilder.dto.project.FileContentResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.FileNode;
import com.aiProjectBuilder.aiProjectBuilder.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(Long id, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFile(Long projectId, String path) {
        return null;
    }
}
