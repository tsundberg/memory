package se.thinkcode.memory;

import se.thinkcode.memory.notes.AddNoteController;
import se.thinkcode.memory.notes.GetNotesFormController;
import se.thinkcode.memory.notes.NotesRepository;
import spark.Spark;

import static spark.Spark.*;

public class Main {
    public static void main(String... args) {
        staticFileLocation("/public");
        externalStaticFileLocation(".");
        routes();
        Spark.exception(Exception.class, (exception, request, response) -> exception.printStackTrace());
        awaitInitialization();
    }

    private static void routes() {
        NotesRepository repository = new NotesRepository();
        get("/", (req, res) -> new GetNotesFormController().handle(req, res));
        post("/addNote", (req, res) -> new AddNoteController(repository).handle(req, res));
    }
}
