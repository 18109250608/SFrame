package com.demo.repository;

import com.demo.entity.Todo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")
public interface TodoRepository extends MongoRepository<Todo, String>{
//    List<Todo> findByDescLike(@Param("desc") String desc);
//
//    List<Todo> findByCompleted(@Param("completed") boolean completed);
//
//    List<Todo> findByUserEmail(@Param("userEmail") String userEmail);

    List<Todo> findByUserId(@Param("userId") ObjectId userId);

//    List<Todo> findByUserIdAndDescLike(@Param("userId") ObjectId userId, @Param("desc") String desc);
//
//    @Query("{ 'user._id': ?0, 'desc': { '$regex': ?1} }")
//    List<Todo> searchTodos(@Param("userId") ObjectId userId, @Param("desc") String desc);
}
