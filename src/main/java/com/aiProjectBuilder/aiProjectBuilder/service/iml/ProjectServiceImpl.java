package com.aiProjectBuilder.aiProjectBuilder.service.iml;

import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.project.ProjectSummaryResponse;
import com.aiProjectBuilder.aiProjectBuilder.entity.Project;
import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectMember;
import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectMemberId;
import com.aiProjectBuilder.aiProjectBuilder.entity.User;
import com.aiProjectBuilder.aiProjectBuilder.enums.ProjectRole;
import com.aiProjectBuilder.aiProjectBuilder.errors.BadRequestException;
import com.aiProjectBuilder.aiProjectBuilder.errors.ResourceNotFoundException;
import com.aiProjectBuilder.aiProjectBuilder.mapper.ProjectMapper;
import com.aiProjectBuilder.aiProjectBuilder.repository.ProjectMemberRepository;
import com.aiProjectBuilder.aiProjectBuilder.repository.ProjectRepository;
import com.aiProjectBuilder.aiProjectBuilder.repository.UserRepository;
import com.aiProjectBuilder.aiProjectBuilder.security.AuthUtil;
import com.aiProjectBuilder.aiProjectBuilder.service.ProjectService;
import com.aiProjectBuilder.aiProjectBuilder.service.SubscriptionService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
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
    SubscriptionService subscriptionService;
    AuthUtil authUtil;

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest) {
        Long userId = authUtil.getCurrentUserId();
        if(!subscriptionService.canCreateNewProject()) {
            throw new BadRequestException("User cannot create a New project with current Plan, Upgrade plan now.");
        }

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
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectResponse getUserProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        return projectMapper.toProjectResponse(project);
    }


    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public ProjectResponse updateProject(Long projectId, ProjectRequest projectRequest) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        project.setName(projectRequest.name());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDeleteProject(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    ///  INTERNAL FUNCTIONS
    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
