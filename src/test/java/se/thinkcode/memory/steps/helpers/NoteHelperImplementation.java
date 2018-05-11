package se.thinkcode.memory.steps.helpers;

import se.thinkcode.memory.notes.Note;

import java.util.List;

public interface NoteHelperImplementation {
    void addNote(String user, String note);

    void save();

    List<Note> getNotes(String currentUser);

    void clean();
}
