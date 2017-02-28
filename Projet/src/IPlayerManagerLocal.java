import javax.ejb.Local;

/**
 * Created by saradion on 18/01/17.
 */
@Local
public interface IPlayerManagerLocal  {
    int subscribe(String username, String mail);
}
