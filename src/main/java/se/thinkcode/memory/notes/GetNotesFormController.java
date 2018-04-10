package se.thinkcode.memory.notes;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class GetNotesFormController implements Route {
    @Override
    public Object handle(Request request, Response response) {
        return new MustacheTemplateEngine().render(process(request));
    }

    private ModelAndView process(Request request) {
        Map<String, Object> map = new HashMap<>();
        return new ModelAndView(map, "addNote.mustache");
    }
}
