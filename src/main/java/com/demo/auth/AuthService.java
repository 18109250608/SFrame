package com.demo.auth;

import com.demo.entity.User;

public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}

