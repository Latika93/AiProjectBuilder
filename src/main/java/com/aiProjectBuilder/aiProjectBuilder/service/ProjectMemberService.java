package com.aiProjectBuilder.aiProjectBuilder.service;

import com.aiProjectBuilder.aiProjectBuilder.dto.member.InviteMemberRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.member.MemberResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.member.UpdateMemberRoleRequest;
import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {

    List<MemberResponse> getProjectMembers(Long id);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest inviteMemberRequest);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest inviteMemberRequest);

    void removeProjectMember(Long projectId, Long memberId);

}