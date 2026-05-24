package com.aiProjectBuilder.aiProjectBuilder.mapper;

import com.aiProjectBuilder.aiProjectBuilder.dto.project.FileNode;
import com.aiProjectBuilder.aiProjectBuilder.entity.ProjectFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    List<FileNode> toListOfFileNode(List<ProjectFile> projectFileList);
}