package com.example.demo.entity;

import lombok.Data;

@Data
public class Note {
    private long id;
    private String title;
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.id = 0;
    }

    public Note(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
