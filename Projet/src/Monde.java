import entities.Joueur;

import java.util.ArrayList;
import java.util.List;

public class Monde {
    private int tailleX;
    private int tailleY;
    private List<Joueur> listeJoueurs;

    public Monde(int x, int y) {
        tailleX = x;
        tailleY = y;
        listeJoueurs = new ArrayList<Joueur>();
    }

    public void ajouterJoueur(Joueur j) {
        listeJoueurs.add(j);
    }

    public int getTailleX() {
        return tailleX;
    }

    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
    }

    public int getTailleY() {
        return tailleY;
    }

    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
    }

    public List<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(List<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }
}
