package com.aiProjectBuilder.aiProjectBuilder.dto.member;

import com.aiProjectBuilder.aiProjectBuilder.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole projectRole
) {
}
