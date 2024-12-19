package com.example.LV1.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseCreateDto {
    //속성
    private Long id;
    private String todoTitle;
    private String todoContents;
    private LocalDateTime createAt;

    //생성자

    //기능
    public TodoResponseCreateDto(
            Long id,
            String todoTitle,
            String todoContents,
            LocalDateTime createAt
    ) {
        this.id = id;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
        this.createAt = createAt;
    }

    }
