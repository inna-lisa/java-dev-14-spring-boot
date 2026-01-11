package com.example.demo.dao.service;

import com.example.demo.entity.Note;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDaoServiceInListImpl implements NoteDaoService {

    private final Map<Long, Note> noteMemory = new HashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Note add(final Note note) {
        if (note.getId() == 0) {
            note.setId(idGenerator.getAndIncrement());
        }
        noteMemory.put(note.getId(), note);
        return note;
    }

    @Override
    public Note getById(long id) {
        for (long l : noteMemory.keySet()) {
            if (l == id) {
                return noteMemory.get(id);
            }
        }
        return null;
    }

    @Override
    public List<Note> listAll() {
        return new ArrayList<>(noteMemory.values());
    }

    @Override
    public void update(final Note note) {
        for (long l : noteMemory.keySet()) {
            if (l == note.getId()) {
                noteMemory.replace(l, note);
                break;
            }
        }
    }

    @Override
    public void deleteById(long id) {
        for (long l : noteMemory.keySet()) {
            if (l == id) {
                noteMemory.remove(id);
                break;
            }
        }
    }
}
