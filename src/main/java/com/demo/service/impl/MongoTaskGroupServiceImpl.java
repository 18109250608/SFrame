package com.demo.service.impl;

import com.demo.entity.Project;
import com.demo.entity.TaskGroup;
import com.demo.repository.TaskGroupRepository;
import com.demo.service.IProjectService;
import com.demo.service.ITaskGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoTaskGroupServiceImpl implements ITaskGroupService {

    private TaskGroupRepository repository;
    private IProjectService projectService;

    @Autowired
    public MongoTaskGroupServiceImpl(
            TaskGroupRepository repository,
            IProjectService projectService){
        this.repository = repository;
        this.projectService = projectService;
    }

    @Override
    public TaskGroup add(TaskGroup group, String projectId) {
        Project project = projectService.findById(projectId);
        TaskGroup added = repository.insert(group);
        project.getGroups().add(added);
        projectService.update(project);
        return added;
    }

    @Override
    public TaskGroup delete(String id) {
        final TaskGroup group = repository.findById(id).get();
        repository.delete(group);
        return group;
    }

    @Override
    public TaskGroup findById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public TaskGroup update(TaskGroup group) {
        return repository.save(group);
    }
}
