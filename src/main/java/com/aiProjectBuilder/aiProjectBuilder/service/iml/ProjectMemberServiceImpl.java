package com.aiProjectBuilder.aiProjectBuilder.service.iml;

import com.aiProjectBuilder.aiProjectBuilder.dto.member.InviteMemberRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.member.MemberResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.member.UpdateMemberRoleRequest;
import com.aiProjectBuilder.aiProjectBuilder.entity.Project;
import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectMember;
import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectMemberId;
import com.aiProjectBuilder.aiProjectBuilder.entity.User;
import com.aiProjectBuilder.aiProjectBuilder.mapper.ProjectMemberMapper;
import com.aiProjectBuilder.aiProjectBuilder.repository.ProjectMemberRepository;
import com.aiProjectBuilder.aiProjectBuilder.repository.ProjectRepository;
import com.aiProjectBuilder.aiProjectBuilder.repository.UserRepository;
import com.aiProjectBuilder.aiProjectBuilder.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;


    @Override
    @PreAuthorize("@security.canViewMembers(#projectId)")
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();
    }

    @Override
    @PreAuthorize("@security.canManageMembers(#projectId)")
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if(invitee.getId().equals(userId)) {
            throw new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());

        if(projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Cannot invite once again");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    @PreAuthorize("@security.canManageMembers(#projectId)")
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest inviteMemberRequest, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(inviteMemberRequest.projectRole());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    @PreAuthorize("@security.canManageMembers(#projectId)")
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if(!projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Member not found in project");
        }

        projectMemberRepository.deleteById(projectMemberId);
    }

    ///  INTERNAL FUNCTIONS

    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
