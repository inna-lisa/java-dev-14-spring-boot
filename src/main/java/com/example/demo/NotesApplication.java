package com.example.demo;

import com.example.demo.entity.Note;
import com.example.demo.service.NoteServiceImpl;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NotesApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(NotesApplication.class, args);

        NoteServiceImpl service = context.getBean(NoteServiceImpl.class);

        service.add(new Note("Birthday", "Inna 22.10"));
        service.add(new Note("Birthday", "Lena 10.12"));
        service.add(new Note("Birthday", "Anna 11.05"));
        service.add(new Note("Lesson", "Math 15.03 14:30"));
        service.add(new Note("Lesson", "Math 19.03 14:30"));

        System.out.println("getById(1) = " + service.getById(1L));
        //System.out.println("getById(5) = " + service.getById(5L));

        service.update(new Note(2L, "Wedding", "Lena 10.12"));
        //service.update(new Note(5L, "Wedding", "Lena 10.12"));

        //service.deleteById(1L);

        List<Note> notes = service.listAll();
        for (Note note : notes) {
            System.out.println(note);
        }
    }
}
