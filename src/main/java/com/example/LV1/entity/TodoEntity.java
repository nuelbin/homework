package com.example.LV1.entity;

import com.example.LV1.dto.request.TodoRequestEditDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "todos")
public class TodoEntity{

    //속성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName; //유저 이름
    private String todoTitle; //할일 제목
    private String todoContents; //할일 내용

    @CreatedDate //작성일
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate //수정일
    private LocalDateTime updatedAt;

    //생성자
    public TodoEntity() {} //JPA 사용시 필수 생성자

    public TodoEntity(String userName, String todoTitle, String todoContents) {
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    //기능
    public void update(TodoRequestEditDto editRequestDto) {
        this.todoTitle = editRequestDto.getTodoTitle();
        this.todoContents = editRequestDto.getTodoContents();
        this.updatedAt = LocalDateTime.now();
    }

}
