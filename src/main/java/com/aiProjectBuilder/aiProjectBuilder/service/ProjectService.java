package com.aiProjectBuilder.aiProjectBuilder.service;

import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectSummaryResponse;

public interface ProjectService {
    ProjectSummaryResponse getUserProjects(Long id);
    ProjectResponse getUserProjectById(Long id, Long userId);
    ProjectResponse createProject(ProjectRequest projectRequest, Long userId);
    ProjectResponse updateProject(ProjectRequest projectRequest, Long id);
    void softDeleteProject(Long id, Long userId);
}
