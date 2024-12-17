package com.example.LV1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class TodoEntity{
    //속성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String TodoTitle;
    private String TodoContents;


    //생성자
    protected TodoEntity() {}
    //기능
}
