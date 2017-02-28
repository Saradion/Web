import entities.Joueur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless(name = "PlayerManager")
public class PlayerManager implements IPlayerManagerLocal, IPlayerManagerRemote {

    @PersistenceContext(unitName = "MaPU")
    private EntityManager em;

    @Override
    public int subscribe(String username, String mail) {
        TypedQuery<Joueur> req1 = em.createQuery("select p from Joueur p where p.username = :username", Joueur.class);
        req1.setParameter("username", username);
        try {
            if (req1.getSingleResult() != null) {
                System.out.println(-1);
                return -1;
            }
        } catch (Exception e) {
        }
        TypedQuery<Joueur> req2 = em.createQuery("select p from Joueur p where p.mail = :mail", Joueur.class);
        req2.setParameter("mail", mail);
        try {
            if (req2.getSingleResult() != null) {
                System.out.println(-2);
                return -2;
            }
        } catch (Exception e ) {
        }

        em.persist(new Joueur(username, mail));
        return 0;
    }
}
