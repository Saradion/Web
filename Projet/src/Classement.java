import entities.Joueur;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Classement {
    private List<Joueur> listeJoueurs;

    public Classement() {
        listeJoueurs = new ArrayList<Joueur>();
    }

    public void ajouterJoueur(Joueur j) {
        listeJoueurs.add(j);
    }

    @Transient
    public List<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(List<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
