package com.demo.repository;

import com.demo.entity.TaskGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskGroupRepository extends MongoRepository<TaskGroup, String> {}
