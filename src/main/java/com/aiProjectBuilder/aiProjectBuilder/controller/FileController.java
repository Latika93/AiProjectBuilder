package com.aiProjectBuilder.aiProjectBuilder.controller;

import com.aiProjectBuilder.aiProjectBuilder.dto.project.FileContentResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.FileNode;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.FileTreeResponse;
import com.aiProjectBuilder.aiProjectBuilder.service.FileService;
import com.aiProjectBuilder.aiProjectBuilder.service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/files")
public class FileController {

    private final ProjectFileService projectFileService;

    @GetMapping
    public ResponseEntity<FileTreeResponse> getFileTree(@PathVariable Long projectId) {
        return ResponseEntity.ok(projectFileService.getFileTree(projectId));
    }

    @GetMapping("/content")
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable Long projectId,
            @RequestParam String path) {
        return ResponseEntity.ok(projectFileService.getFileContent(projectId, path));
    }

}
