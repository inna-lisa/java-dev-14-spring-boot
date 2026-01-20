package com.example.demo.service;

import com.example.demo.entity.Note;
import com.example.demo.repository.NoteRepository;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("db")
public class NoteServiceInDbImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceInDbImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note getById(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new NoteNotFoundExeption(id));
    }

    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public void update(Note note) {
        noteRepository.findById(note.getId()).orElseThrow(() -> new NoteNotFoundExeption(note.getId()));

        noteRepository.save(note);
    }

    @Override
    public void deleteById(Long id) {
        noteRepository.findById(id).orElseThrow(() -> new NoteNotFoundExeption(id));
        noteRepository.deleteById(id);
    }
}
