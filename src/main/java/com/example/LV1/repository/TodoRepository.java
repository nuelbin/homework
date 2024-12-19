package com.example.LV1.repository;

import com.example.LV1.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import java.util.Optional;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    Optional<TodoEntity> findById(Long id);

}
