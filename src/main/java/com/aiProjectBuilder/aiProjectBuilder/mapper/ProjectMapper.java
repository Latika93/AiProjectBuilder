package com.aiProjectBuilder.aiProjectBuilder.mapper;

import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectSummaryResponse;
import com.aiProjectBuilder.aiProjectBuilder.entity.Project;
import com.aiProjectBuilder.aiProjectBuilder.enums.ProjectRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project, ProjectRole role);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}
