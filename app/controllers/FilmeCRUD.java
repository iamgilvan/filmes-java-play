package controllers;

import models.Diretor;
import models.Filme;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import static play.data.Form.form;

/**
 * Created by gilvan on 12/06/17.
 */
public class FilmeCRUD extends Controller {

    private static final Form<Filme> filmeForm = form(Filme.class);

    public static Result lista(){
        List<Filme> filmes = Filme.find.where().orderBy("ano").findList();
        return ok(views.html.filme.render(filmes));
    }

    public static Result remover(Long id) {
        Filme.find.ref(id).delete();
        flash("sucesso","Filme removido com sucesso");
        return lista();
    }

    public static Result novoFilme(){
        List<Diretor> diretores = Diretor.find.findList();
        return ok(views.html.novoFilme.render(filmeForm,diretores));
    }

    public static Result detalhar(Long id){
        Form<Filme> filmeForm = form(Filme.class).fill(Filme.find.byId(id));
        return ok(views.html.alterarFilme.render(id,filmeForm));
    }

    public static Result alterar(Long id) {
        form(Filme.class).fill(Filme.find.byId(id));

        Form<Filme> alterarForm = form(Filme.class).bindFromRequest();
        if (alterarForm.hasErrors()){
            return badRequest(views.html.alterarFilme.render(id,alterarForm));
        }
        alterarForm.get().update(Long.toString(id));
        //alterarForm.get().update(java.lang.Object id);


        flash("sucesso","Filme " + alterarForm.get().nome + " alterado com sucesso");

        return redirect(routes.FilmeCRUD.lista());
    }

    public static Result gravar(){
        Form<Filme> form = filmeForm.bindFromRequest();
        if (form.hasErrors()){
            flash("erro","Foram identificados problemas no cadastro de filmes");
            List<Diretor> diretores = Diretor.find.findList();
            return ok(views.html.novoFilme.render(filmeForm, diretores));
        }

        form.get().save();

        flash("sucesso","Registro gravado com sucesso");

        return redirect(routes.FilmeCRUD.lista());
    }
}
