package com.example.demo.service;

import com.example.demo.entity.Note;
import java.util.List;

public interface NoteService {

    Note add(Note note);

    Note getById(Long id);

    List<Note> listAll();

    void update(Note note);

    void deleteById(Long id);
}
