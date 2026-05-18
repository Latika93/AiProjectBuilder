package com.aiProjectBuilder.aiProjectBuilder.controller;

import com.aiProjectBuilder.aiProjectBuilder.dto.member.InviteMemberRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.member.MemberResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.member.UpdateMemberRoleRequest;
import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectMember;
import com.aiProjectBuilder.aiProjectBuilder.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/members")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId, userId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId, @RequestBody InviteMemberRequest inviteMemberRequest){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.inviteMember(projectId, inviteMemberRequest, userId));
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long projectId, @PathVariable Long memberId, @RequestBody UpdateMemberRoleRequest updateMemberRoleRequest){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId, memberId, updateMemberRoleRequest));
    }
    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponse> deleteMember(@PathVariable Long projectId, @PathVariable Long memberId){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.deleteMember(projectId, memberId));
    }
}
