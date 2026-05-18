package com.aiProjectBuilder.aiProjectBuilder.service.iml;

import com.aiProjectBuilder.aiProjectBuilder.dto.member.InviteMemberRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.member.MemberResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.member.UpdateMemberRoleRequest;
import com.aiProjectBuilder.aiProjectBuilder.service.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<MemberResponse> getProjectMembers(Long id, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest inviteMemberRequest, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest inviteMemberRequest) {
        return null;
    }

    @Override
    public MemberResponse deleteMember(Long projectId, Long memberId) {
        return null;
    }
}
