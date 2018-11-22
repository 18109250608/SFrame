package com.demo.service;

import com.demo.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    Project add(Project project, String userId);
    Project delete(String id);
    Page<Project> findRelated(String userId, boolean enabled, boolean archived, Pageable pageable);
    Project findById(String id);
    Project update(Project project);
}