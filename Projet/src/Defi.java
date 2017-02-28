import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Classe Defi
 *
 * @author mbouette
 */
@Entity
public class Defi {
    /**
     * l'identifiant du defi.
     */
    @Id
    @GeneratedValue
    private int id;
    /**
     * Le monde qui correspond au defi.
     */
    @Transient
    private Monde monde;
    /**
     * la description du defi.
     */
    private String description;
    /**
     * ce que gagne le joueur s'il reussi le defi.
     */
    private int score;

    /**
     * Constructeur Defi.
     *
     * @param m,          le monde associe au defi
     * @param descrip,    la description associee au defi
     * @param recompense, la recompense pour qui reussi le defi
     */
    public Defi(Monde m, String descrip, int recompense) {
        monde = m;
        description = descrip;
        score = recompense;
    }

    public Monde getMonde() {
        return monde;
    }

    public void setMonde(Monde monde) {
        this.monde = monde;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
