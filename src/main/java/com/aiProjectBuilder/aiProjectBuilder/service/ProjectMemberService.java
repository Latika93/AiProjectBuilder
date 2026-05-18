package com.aiProjectBuilder.aiProjectBuilder.service;

import com.aiProjectBuilder.aiProjectBuilder.dto.member.InviteMemberRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.member.MemberResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.member.UpdateMemberRoleRequest;
import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {

    List<MemberResponse> getProjectMembers(Long id, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest inviteMemberRequest, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest inviteMemberRequest);

    MemberResponse deleteMember(Long projectId, Long memberId);
}
