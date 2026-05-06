package com.aiProjectBuilder.aiProjectBuilder.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

import static lombok.AccessLevel.*;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class Preview {

    Long id;
    Project project;
    String namespace;
    String podName;
    String previewUrl;

    Instant startedAt;
    Instant terminatedAt;

    Instant createdAt;
}
