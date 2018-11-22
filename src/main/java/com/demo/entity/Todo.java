package com.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Todo {
    @Id private String id;
    private String desc;
    private boolean completed;
    private User user;
}