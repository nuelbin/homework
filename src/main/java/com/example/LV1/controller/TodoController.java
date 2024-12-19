package com.example.LV1.controller;


import com.example.LV1.dto.request.TodoRequestCreateDto;
import com.example.LV1.dto.request.TodoRequestEditDto;
import com.example.LV1.dto.response.TodoResponseDto;
import com.example.LV1.dto.response.TodoResponseListDto;
import com.example.LV1.dto.response.TodoResponseCreateDto;
import com.example.LV1.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //로그 사용 어노테이션
@RestController //스프링 빈에 자동 등록 어노테이션
@RequiredArgsConstructor //생성자 자동 생성
@RequestMapping("/todos")
public class TodoController {

    //속성
    private final TodoService todoService;

    //생성자(자동 생성)

    //기능(HTTP METHOD)
    @PostMapping
    public ResponseEntity<TodoResponseCreateDto> createTodoAPI(@RequestBody TodoRequestCreateDto todoRequestCreateDto) {
        TodoResponseCreateDto creatResponse =
                todoService.createTodo(todoRequestCreateDto);
        log.info("::: 할 일 등록 API 가 동작하였습니다. ");
        return new ResponseEntity<>(creatResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> findById(@PathVariable Long id) {
        TodoResponseDto getTodoResponseDto = todoService.findById(id);
        log.info("::: 할 일 단건 조회 API 가 동작하였습니다. ");
        return new ResponseEntity<>(getTodoResponseDto, HttpStatus.OK);
}
    @GetMapping
    public ResponseEntity<List<TodoResponseListDto>> findAll() {
        List<TodoResponseListDto> todoResponseListDto = todoService.findAll();
        log.info("::: 할 일 목록 조회 API 가 동작하였습니다. ");
        return new ResponseEntity<>(todoResponseListDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(@PathVariable Long id,
                                                      @RequestBody TodoRequestEditDto putRequestDto) {
        TodoResponseDto updatedTodo = todoService.updateContents(id, putRequestDto);
        log.info("::: 할 일 수정 API 가 동작하였습니다.");
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        log.info("::: 할 일 삭제 API 가 동작하였습니다.");
        return ResponseEntity.noContent().build();
    }
}

