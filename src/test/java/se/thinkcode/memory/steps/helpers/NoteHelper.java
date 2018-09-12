package se.thinkcode.memory.steps.helpers;

import cucumber.api.java.After;
import se.thinkcode.memory.notes.Note;

import java.util.List;

public class NoteHelper {
    private static NoteHelperImplementation helper = null;

    public NoteHelper() {
        String browser = System.getProperties().getProperty("browser");

        if (helper == null) {
            if (browser != null && browser.equalsIgnoreCase("true")) {
                helper = new BrowserNoteHelper();
            } else {
                helper = new InMemoryNoteHelper();
            }
        }
    }

    @After
    public void tearDown() {
        helper.clean();
    }

    public void addNote(String user, String note) {
        helper.addNote(user, note);
    }

    public void save() {
        helper.save();
    }

    public List<Note> getNotes(String currentUser) {
        return helper.getNotes(currentUser);
    }
}