package com.aiProjectBuilder.aiProjectBuilder.repository;

import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectMember;
import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);
}
