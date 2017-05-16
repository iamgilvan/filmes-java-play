package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result sobre() {
        //return ok("Sobre");
        return ok(views.html.sobre.render("Top 100 filmes Cult", play.core.PlayVersion.current()));
    }

}
