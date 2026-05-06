package com.aiProjectBuilder.aiProjectBuilder.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsageLog { // helps to manage quota
    Long id;
    User user;
    Project project;

    String action;

    Integer tokenUsed;
    Integer durationMs;

    String metaData;

    Instant createdAt;
}
