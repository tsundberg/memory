package se.thinkcode.memory.notes;

import se.thinkcode.memory.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesRepository {
    private Map<User, List<Note>> noteRepository = new HashMap<>();

    public void save(User user, Note note) {
        List<Note> notes = noteRepository.computeIfAbsent(user, k -> new ArrayList<>());
        notes.add(note);
    }

    public List<Note> getNotes(User user) {
        return noteRepository.get(user);
    }
}
