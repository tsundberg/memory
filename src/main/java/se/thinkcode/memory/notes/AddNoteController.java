package se.thinkcode.memory.notes;

import se.thinkcode.memory.user.User;
import spark.Request;
import spark.Response;
import spark.Route;

public class AddNoteController implements Route {
    private NotesRepository repository;

    public AddNoteController(NotesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Object handle(Request request, Response response) {
        return process(request);
    }

    private String process(Request request) {
        String name = request.queryParams("name");
        String noteText = request.queryParams("note");

        User user = new User(name);
        Note note = new Note(noteText);

        repository.save(user, note);

        return noteText;
    }
}