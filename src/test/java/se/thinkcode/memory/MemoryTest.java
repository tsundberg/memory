package se.thinkcode.memory;

import org.junit.Test;
import se.thinkcode.memory.notes.Note;
import se.thinkcode.memory.steps.helpers.InMemoryNoteHelper;
import se.thinkcode.memory.steps.helpers.NoteHelperImplementation;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryTest {

    @Test
    public void should_save_a_note_about_an_upcomming_concert() {
        NoteHelperImplementation helper = new InMemoryNoteHelper();
        String user = "Malin";
        Note note = new Note("book Eric Ericssonhallen for Kårsdragets concert in autumn");
        helper.addNote(user, note.toString());
        helper.save();

        List<Note> notes = helper.getNotes(user);

        assertThat(notes).contains();
    }
}
