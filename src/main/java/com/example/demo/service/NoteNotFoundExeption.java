package com.example.demo.service;

public class NoteNotFoundExeption extends RuntimeException {
    public NoteNotFoundExeption(Long id) {
        super("Note with id " + id + " not found");
    }
}
