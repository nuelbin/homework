package com.example.LV1.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TodoRequestCreateDto {

    //속성
    private String userName; //유저이름

    private String todoTitle; //할 일 제목

    private String todoContents; //할 일 내용

    private LocalDateTime createAt; // 작성 시간

    //생성자

    //기능
    public TodoRequestCreateDto(String userName, String todoTitle, String todoContents, LocalDateTime createAt) {
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
        this.createAt = createAt;
    }
}
