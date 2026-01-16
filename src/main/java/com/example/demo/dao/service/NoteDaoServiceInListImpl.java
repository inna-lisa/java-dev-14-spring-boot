package com.example.demo.dao.service;

import com.example.demo.entity.Note;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("memory")
public class NoteDaoServiceInListImpl implements NoteDaoService {

    private final Map<Long, Note> noteMemory = new HashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Note add(final Note note) {
        if (note.getId() == null) {
            note.setId(idGenerator.getAndIncrement());
        }
        noteMemory.put(note.getId(), note);
        return note;
    }

    @Override
    public Note getById(Long id) {
        for (Long l : noteMemory.keySet()) {
            if (l.equals(id)) {
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
        for (Long l : noteMemory.keySet()) {
            if (l.equals(note.getId())) {
                noteMemory.replace(l, note);
                break;
            }
        }
    }

    @Override
    public void deleteById(Long id) {
        for (Long l : noteMemory.keySet()) {
            if (l.equals(id)) {
                noteMemory.remove(id);
                break;
            }
        }
    }
}
