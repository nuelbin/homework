package com.example.LV1.dto.response;

import com.example.LV1.entity.TodoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class TodoResponseDto {
    private final String userName;
    private final String todoTitle;
    private final String todoContents;
    private final LocalDateTime updateAt;

    public TodoResponseDto(TodoEntity todoEntity) {
        this.userName = todoEntity.getUserName();
        this.todoTitle = todoEntity.getTodoTitle();
        this.todoContents = todoEntity.getTodoContents();
        this.updateAt = todoEntity.getUpdatedAt();
    }
}
