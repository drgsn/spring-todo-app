package com.todo.service;

import com.todo.dto.TodoDTO;
import com.todo.model.Todo;
import com.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public TodoDTO createTodo(TodoDTO dto){
        Todo todo = new Todo();
        todo.setDescription(dto.getDescription());
        todo.setName(dto.getName());
//        todo.setCreatedAt(LocalDateTime.now());
        dto.setId(repository.save(todo).getId());
        return dto;
    }

    public TodoDTO updateTodo(TodoDTO dto) {
        Todo todo = new Todo();
        todo.setId(dto.getId());
        todo.setDescription(dto.getDescription());
        todo.setName(dto.getName());
//        todo.setCreatedAt(LocalDateTime.now());
        dto.setId(repository.save(todo).getId());
        return dto;

    }

    public Optional<Todo> getTodo(Long id) {
        Optional<Todo> todo = repository.findById(id);
        return todo;
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }
}
