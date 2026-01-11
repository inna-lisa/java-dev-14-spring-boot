package com.example.demo.entity;

import lombok.Data;

@Data
public class Note {
    private long id;
    private final String title;
    private final String context;

    public Note(String title, String context) {
        this.title = title;
        this.context = context;
        this.id = 0;
    }

    public Note(long id, String title, String context) {
        this.id = id;
        this.title = title;
        this.context = context;
    }
}
