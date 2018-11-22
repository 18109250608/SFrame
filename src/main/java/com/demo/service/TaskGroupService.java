package com.demo.service;

import com.demo.entity.TaskGroup;

public interface TaskGroupService {
    TaskGroup add(TaskGroup group, String projectId);
    TaskGroup delete(String id);
    TaskGroup findById(String id);
    TaskGroup update(TaskGroup group);
}
