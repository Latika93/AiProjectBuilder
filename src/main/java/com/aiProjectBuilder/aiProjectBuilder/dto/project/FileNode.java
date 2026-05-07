package com.aiProjectBuilder.aiProjectBuilder.dto.project;

import java.time.Instant;

public record FileNode(
        String path,
        Instant modifiedAt,
        Instant createdAt
) {
}
