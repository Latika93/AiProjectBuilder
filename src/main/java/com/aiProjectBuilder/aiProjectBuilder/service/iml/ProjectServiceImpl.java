package com.aiProjectBuilder.aiProjectBuilder.service.iml;

import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectSummaryResponse;
import com.aiProjectBuilder.aiProjectBuilder.entity.Project;
import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectMember;
import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectMemberId;
import com.aiProjectBuilder.aiProjectBuilder.entity.User;
import com.aiProjectBuilder.aiProjectBuilder.enums.ProjectRole;
import com.aiProjectBuilder.aiProjectBuilder.errors.ResourceNotFoundException;
import com.aiProjectBuilder.aiProjectBuilder.mapper.ProjectMapper;
import com.aiProjectBuilder.aiProjectBuilder.repository.ProjectMemberRepository;
import com.aiProjectBuilder.aiProjectBuilder.repository.ProjectRepository;
import com.aiProjectBuilder.aiProjectBuilder.repository.UserRepository;
import com.aiProjectBuilder.aiProjectBuilder.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User", userId.toString())
        );

        Project project = Project.builder()
                .name(projectRequest.name())
                .isPublic(false)
                .build();

        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);


        return projectMapper.toProjectResponse(project); // mapstriuct
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        return projectMapper.toProjectResponse(project);
    }


    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest projectRequest, Long userId) {
        Project project = getAccessibleProjectById(id, userId);

        project.setName(projectRequest.name());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDeleteProject(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    ///  INTERNAL FUNCTIONS
    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
