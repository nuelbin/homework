package com.example.LV1.service;

import com.example.LV1.dto.request.TodoRequestCreateDto;
import com.example.LV1.dto.request.TodoRequestEditDto;
import com.example.LV1.dto.response.TodoResponseDto;
import com.example.LV1.dto.response.TodoResponseListDto;
import com.example.LV1.dto.response.TodoResponseCreateDto;
import com.example.LV1.entity.TodoEntity;
import com.example.LV1.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class TodoService {
    //속성
    private final TodoRepository todoRepository;
    //생성자(자동 생성)

    //기능
    /**
     * 할 일 생성 로직
     * @param todoRequestCreateDto
     * @return
     *
     */
    public TodoResponseCreateDto createTodo(TodoRequestCreateDto todoRequestCreateDto) {

        TodoEntity todoEntity = new TodoEntity(
                todoRequestCreateDto.getUserName(),
                todoRequestCreateDto.getTodoTitle(),
                todoRequestCreateDto.getTodoContents());

        TodoEntity saveTodo =  todoRepository.save(todoEntity);

        log.info("::: 일정 등록 서비스가 동작하였습니다.");
        return new TodoResponseCreateDto(
                saveTodo.getId(),
                saveTodo.getTodoTitle(),
                saveTodo.getTodoContents(),
                saveTodo.getCreatedAt()
        );
    }

    /**
     * 할 일 단건 조회 로직
     * @param id
     * @return
     */
    public TodoResponseDto findById(Long id) {
        Optional<TodoEntity> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재 하지 않는 id값 입니다. = " + id);
        }
        TodoEntity findTodo = optionalTodo.get();
        log.info("::: 일정 조회 서비스가 정상적으로 작동 하였습니다.");
        return new TodoResponseDto(
                findTodo.getUserName(),
                findTodo.getTodoTitle(),
                findTodo.getTodoContents(),
                findTodo.getCreatedAt());
    }

    /**
     * 할 일 목록 조회 로직
     * @return
     */
    public List<TodoResponseListDto> findAll() {
       log.info("::: 일정 목록 조회 서비스가 정상적으로 작동 하였습니다.");
        return todoRepository.findAll()
                .stream()
                .map(TodoResponseListDto::toDto)
                .toList();
    }

    /**
     * 할 일 수정 로직
     * @param id
     * @param editRequestDto
     * @return
     */
    @Transactional
    public TodoResponseDto updateContents(Long id, TodoRequestEditDto editRequestDto) {
        TodoEntity todoEntity = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다."));
        todoEntity.update(editRequestDto);
        log.info("::: 일정 수정 서비스가 정상적으로 작동하였습니다.");
        return new TodoResponseDto(todoEntity);

    }

    /**
     * 할 일 삭제 로직
     * @param id
     */
    @Transactional
    public void deleteTodoById(Long id) {
        TodoEntity todoEntity = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제할 일정을 찾을 수 없습니다."));
        todoRepository.delete(todoEntity);
        log.info("::: 일정 삭제 서비스가 정상적으로 작동하였습니다." );
    }
}


