package controllers;

import models.Filme;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by gilvan on 16/06/17.
 */
public class Services extends Controller{
    private static List<Filme> getFilmesOrderByAno(){
        return Filme.find.where().orderBy("ano").findList();
    }

    public static Result listaFilmesEmXML(){
        List<Filme> filmes = getFilmesOrderByAno();
        return ok("<message \"status\"=\"OK\"> " + filmes.toString() + "</message>");
    }

    public static Result listaFilmesEmJSON(){
        List<Filme> filmes = getFilmesOrderByAno();
        return ok(Json.toJson(filmes));
    }
}
