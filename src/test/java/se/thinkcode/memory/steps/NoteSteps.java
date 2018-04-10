package se.thinkcode.memory.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import se.thinkcode.memory.notes.Note;
import se.thinkcode.memory.steps.helpers.BrowserNoteHelper;
import se.thinkcode.memory.steps.helpers.InMemoryNoteHelper;
import se.thinkcode.memory.steps.helpers.NoteHelper;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteSteps {
    private NoteHelper helper;
    private Note note;

    public NoteSteps() {
        String browser = System.getProperties().getProperty("browser");

        if (browser != null && browser.equalsIgnoreCase("true")) {
            helper = new BrowserNoteHelper();
        } else {
            helper = new InMemoryNoteHelper();
        }
    }

    @After
    public void tearDown() {
        if (helper instanceof BrowserNoteHelper) {
            BrowserNoteHelper browserNoteHelper = (BrowserNoteHelper) helper;
            browserNoteHelper.cleanUp();
        }
    }

    @Given("^(.*) want to remember to (.*)$")
    public void remember_a_note(String user, String note) {
        this.note = new Note(note);
        helper.addNote(user, note);
    }

    @When("^she has entered the details$")
    public void she_has_entered_the_details() {
        helper.save();
    }

    @Then("^should (.*) be able to see the note$")
    public void should_the_user_be_able_to_see_the_note(String user) {
        assertThat(helper.getNotes(user)).contains(note);
    }
}
