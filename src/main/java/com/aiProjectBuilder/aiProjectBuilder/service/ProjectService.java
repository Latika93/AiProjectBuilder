package com.aiProjectBuilder.aiProjectBuilder.service;

import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectSummaryResponse;
import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long id);
    ProjectResponse getUserProjectById(Long id, Long userId);
    ProjectResponse createProject(ProjectRequest projectRequest, Long userId);
    ProjectResponse updateProject(Long id, ProjectRequest projectRequest, Long userId);
    void softDeleteProject(Long id, Long userId);
}
