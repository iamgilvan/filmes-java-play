package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Diretor extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String nome;

    public static Model.Finder<Long,Diretor> find = new Model.Finder<Long,Diretor>(Long.class,Diretor.class);

    @Override
    public String toString() {
        return "Diretor [nome=" + nome + "]";
    }

}
