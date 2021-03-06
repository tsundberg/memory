package se.thinkcode.memory.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import se.thinkcode.memory.notes.Note;
import se.thinkcode.memory.steps.helpers.NoteHelper;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteSteps {
    private NoteHelper helper = new NoteHelper();
    private Note note;

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
