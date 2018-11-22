package com.demo.controller;

import com.demo.entity.TaskGroup;
import com.demo.service.TaskGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taskgroups")
@PreAuthorize("hasRole('USER')")
public class TaskGroupController {

    private TaskGroupService service;

    @Autowired
    public TaskGroupController(TaskGroupService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public TaskGroup add(@RequestBody TaskGroup group, @RequestHeader(value = "projectId") String projectId){
        return service.add(group, projectId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TaskGroup findById(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TaskGroup update(@PathVariable String id, @RequestBody TaskGroup group){
        group.setId(id);
        return service.update(group);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public TaskGroup delete(@PathVariable String id){
        return service.delete(id);
    }
}
