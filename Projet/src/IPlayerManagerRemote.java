import javax.ejb.Remote;

/**
 * Created by saradion on 18/01/17.
 */
@Remote
public interface IPlayerManagerRemote {
    int subscribe(String username, String mail);
}
