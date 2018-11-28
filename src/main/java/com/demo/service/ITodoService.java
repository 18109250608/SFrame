package com.demo.service;

import com.demo.entity.Todo;

import java.util.List;

public interface ITodoService {
    Todo addTodo(Todo todo);
    Todo deleteTodo(String id);
    List<Todo> findAll(String userId);
    Todo findById(String id);
    Todo update(Todo todo);

}
