package com.todo.controller;

import com.todo.dto.TodoDTO;
import com.todo.model.Todo;
import com.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @PostMapping("/v1/todo")
    public ResponseEntity<TodoDTO> createTodo(@RequestBody TodoDTO todo) {
        return ResponseEntity.ok(service.createTodo(todo));
    }

    @GetMapping("/v1/todo")
    public ResponseEntity<List<Todo>> getAllTodo() {
        return ResponseEntity.ok(service.getAllTodos());
    }

    @PutMapping("/v1/todo")
    public ResponseEntity<TodoDTO> updateTodo(@RequestBody TodoDTO todo) {
        return ResponseEntity.ok(service.updateTodo(todo));
    }

    @GetMapping("/v1/todo/{id}")
    public ResponseEntity<?> createTodo(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTodo( id));
    }

}
