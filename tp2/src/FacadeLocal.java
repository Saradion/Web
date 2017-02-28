import beans.Address;
import beans.Person;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by saradion on 22/11/16.
 */
@Local
public interface FacadeLocal {
    void addPerson(String lname, String fname);

    void addAddress(String street, String city);

    Collection<Person> listePersonnes();

    Collection<Address> listeAddress();

    void associer(String personId, String addressId);
}
