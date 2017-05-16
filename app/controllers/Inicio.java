package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by gilvan on 16/05/17.
 */
public class Inicio extends Controller {
    public static Result index(){
        return ok(views.html.inicio.render());
    }
}
