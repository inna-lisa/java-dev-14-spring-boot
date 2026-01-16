package com.example.demo;

import com.example.demo.entity.Note;
import com.example.demo.service.NoteService;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NotesApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(NotesApplication.class, args);

        NoteService service = context.getBean(NoteService.class);
        service.add(new Note("Birthday", "Inna 22.10"));
        service.add(new Note("Birthday", "Lena 10.12"));
        service.add(new Note("Wedding", "Anna 11.05"));
        service.add(new Note("Lesson", "Math 15.03 14:30"));
        service.add(new Note("Lesson", "Math 19.03 14:30"));

        List<Note> notes = service.listAll();
        for (Note note : notes) {
            System.out.println(note);
        }
    }
}
