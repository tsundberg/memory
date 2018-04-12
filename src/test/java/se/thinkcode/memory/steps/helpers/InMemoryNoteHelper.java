package se.thinkcode.memory.steps.helpers;

import se.thinkcode.memory.notes.Note;
import se.thinkcode.memory.notes.NotesRepository;
import se.thinkcode.memory.user.User;

import java.util.List;

public class InMemoryNoteHelper implements NoteHelper {
    private NotesRepository notesRepository = new NotesRepository();
    private User user;
    private Note note;

    @Override
    public void addNote(String user, String note) {
        this.user = new User(user);
        this.note = new Note(note);
    }

    @Override
    public void save() {
        notesRepository.save(user, note);
    }

    @Override
    public List<Note> getNotes(String currentUser) {
        User user = new User(currentUser);
        return notesRepository.getNotes(user);
    }

    @Override
    public void clean() {
    }
}
