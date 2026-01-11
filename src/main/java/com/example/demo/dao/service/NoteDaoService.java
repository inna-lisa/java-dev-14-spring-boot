package com.example.demo.dao.service;

import com.example.demo.entity.Note;
import java.util.List;

public interface NoteDaoService {

    Note add(Note note);

    Note getById(long id);

    List<Note> listAll();

    void update(Note note);

    void deleteById(long id);
}
