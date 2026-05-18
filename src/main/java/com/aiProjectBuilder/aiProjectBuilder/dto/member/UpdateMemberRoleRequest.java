package com.aiProjectBuilder.aiProjectBuilder.dto.member;

import com.aiProjectBuilder.aiProjectBuilder.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole projectRole
) {
}
