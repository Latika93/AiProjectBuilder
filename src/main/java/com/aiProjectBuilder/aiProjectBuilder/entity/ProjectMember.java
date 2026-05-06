package com.aiProjectBuilder.aiProjectBuilder.entity;

import com.aiProjectBuilder.aiProjectBuilder.enums.ProjectRole;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

import static lombok.AccessLevel.*;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class ProjectMember {
    ProjectMemberId id;
    Project project;

    User user;
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}
