package com.example.LV1.dto.response;

import com.example.LV1.entity.TodoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class TodoResponseListDto {
    //속성
    private final Long id;

    private final String userName;
    private final String todoTitle;
    private final String todoContents;
    private final LocalDateTime creatAt;

    //생성자

    //기능
    public static TodoResponseListDto toDto(TodoEntity todoEntity) {
        return new TodoResponseListDto(
                todoEntity.getId(),
                todoEntity.getUserName(),
                todoEntity.getTodoTitle(),
                todoEntity.getTodoContents(),
                todoEntity.getCreatedAt());
    }
}
