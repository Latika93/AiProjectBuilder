package com.aiProjectBuilder.aiProjectBuilder.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

import static lombok.AccessLevel.*;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class Project {
    Long id;
    String name;
    User owner;
    boolean isPublic = false;

    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;
}
