import java.util.ArrayList;
import java.util.List;

/**
 * Classe choixDefis, permet a tous les joueurs d'acceder a chaque defi.
 *
 * @author mbouette
 */

public class ChoixDefis {
    private List<Defi> listeDefis;
    private int tailleMax;

    /**
     * Constructeur ChoixDefis.
     *
     * @param taille, le nombre max de defis a ajouter
     */
    public ChoixDefis(int taille) {
        listeDefis = new ArrayList<Defi>(taille);
        tailleMax = taille;
    }

    public List<Defi> getListeDefis() {
        return listeDefis;
    }

    public int getTailleMax() {
        return tailleMax;
    }

    public void ajoutDefi(Defi def) {
        listeDefis.add(def.getId(), def);
    }
}
