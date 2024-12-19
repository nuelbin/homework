package com.example.LV1.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class TodoRequestEditDto {

    //속성

    private final String todoTitle;

    private final String todoContents;

    private final LocalDateTime updateAt;

    //생성자

    //기능


}
