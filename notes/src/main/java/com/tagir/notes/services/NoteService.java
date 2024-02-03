package com.tagir.notes.services;

import com.tagir.notes.entities.Note;
import com.tagir.notes.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    /**
     * Получение всех заметок
     * @return список заметок
     */
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    /**
     * Добавление заметки
     * @param note заметка
     * @return заметку
     */
    public Note addNote(Note note){
        return noteRepository.save(note);
    }

    /**
     * Получение заметки по id
     * @param id id заметки
     * @return заметки
     */
    public Optional<Note> getNoteById(Long id){
        return noteRepository.findById(id);
    }

    /**
     * Обновление заметки
     * @param id id старой заметки
     * @param note новая заметка
     * @return заметку
     */
    public Note updateNote(Long id, Note note){
        note.setId(id);
        return noteRepository.save(note);
    }

    /**
     * Удаление заметки
     * @param id id удаляемой заметки
     */
    public void deleteNote(Long id){
        noteRepository.deleteById(id);
    }
}
