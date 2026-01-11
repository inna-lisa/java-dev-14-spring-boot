package com.example.demo.service;

import com.example.demo.dao.service.NoteDaoService;
import com.example.demo.entity.Note;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteDaoService noteDaoService;

    public NoteServiceImpl(NoteDaoService noteDaoService) {
        this.noteDaoService = noteDaoService;
    }

    @Override
    public Note add(final Note note) {
        return noteDaoService.add(note);
    }

    @Override
    public Note getById(long id) {
        Note note = noteDaoService.getById(id);
        if (note == null) {
            throw new NoteNotFoundExeption(id);
        }
        return note;
    }

    @Override
    public List<Note> listAll() {
        return noteDaoService.listAll();
    }

    @Override
    public void update(final Note note) {
        if (getById(note.getId()) != null) {
            noteDaoService.update(note);
        }
    }

    @Override
    public void deleteById(long id) {
        if (getById(id) != null) {
            noteDaoService.deleteById(id);
        }
    }
}
