package com.demo.repository;


import com.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByEmailLike(@Param("email") String email);
    User findByUsername(final String username);
}
