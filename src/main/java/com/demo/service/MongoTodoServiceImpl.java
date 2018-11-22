package com.demo.service;

import com.demo.entity.Todo;
import com.demo.repository.TodoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoTodoServiceImpl implements TodoService{
    private final TodoRepository repository;

    @Autowired
    MongoTodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Todo addTodo(Todo todo) {
        return repository.insert(todo);
    }

    @Override
    public Todo deleteTodo(String id) {
        Todo deletedTodo = repository.findById(id).get();
        repository.delete(deletedTodo);
        return deletedTodo;
    }

    @Override
    public List<Todo> findAll(String userId) {
        return repository.findByUserId(new ObjectId(userId));
    }

    @Override
    public Todo findById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Todo update(Todo todo) {
        repository.save(todo);
        return todo;
    }
}