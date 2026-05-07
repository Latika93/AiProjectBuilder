package com.aiProjectBuilder.aiProjectBuilder.dto.member;

import com.aiProjectBuilder.aiProjectBuilder.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole projectRole
) {
}
