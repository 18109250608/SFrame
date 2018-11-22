package com.demo.controller;

import com.demo.entity.Todo;
import com.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 使用@RestController来标记这个类是个Controller
 */

@RestController
@RequestMapping("/todos")
@PreAuthorize("hasRole('USER')")
public class TodoController {
    private TodoService service;

    @RequestMapping("test")
    public String test() {
        return "xiaoma test";
    }


    @Autowired
    public TodoController(TodoService service){
        this.service = service;
    }

    // http://localhost:8080/todos
    // header  带参数userId
    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> getAllTodos(@RequestHeader(value = "userId") String userId) {
        return service.findAll(userId);
    }

    // http://localhost:8080/todos
    // body post 带参数
    // RequestParam 参数不能使用对象！！！！
    @RequestMapping(method = RequestMethod.POST)
    Todo addTodo(@RequestBody Todo addedTodo) {
        return service.addTodo(addedTodo);
    }

    // http://localhost:8080/todos/5bdbe9721ab67c2480627ea9
    // url 带id参数
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Todo getTodo(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Todo updateTodo(@PathVariable String id, @RequestBody Todo updatedTodo) {
        updatedTodo.setId(id);
        return service.update(updatedTodo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    Todo removeTodo(@PathVariable String id) {
        return service.deleteTodo(id);
    }
}