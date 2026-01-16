package com.example.demo.repository;

import com.example.demo.entity.Note;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("db")
public interface NoteRepository extends JpaRepository<Note, Long> {
}
