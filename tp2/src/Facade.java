import beans.Address;
import beans.Person;

import javax.ejb.Singleton;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by saradion on 22/11/16.
 */
@Singleton(name = "Facade")
public class Facade implements FacadeRemote, FacadeLocal {
    private Map<String, Person> persons;
    private Map<String, Address> addresses;

    public Facade() {
        persons = new HashMap<>();
        addresses = new HashMap<>();
    }

    @Override
    public void addPerson(String lname, String fname) {
        try {
            Person newPerson = new Person(lname, fname);
            persons.put(newPerson.getId(), newPerson);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAddress(String street, String city) {
        try {
            Address newAddress = new Address(street, city);
            addresses.put(newAddress.getId(), newAddress);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Collection<Person> listePersonnes() {
        return persons.values();
    }

    @Override
    public Collection<Address> listeAddress() {
        return addresses.values();
    }

    @Override
    public void associer(String personId, String addressId) {
        if (personId == null)
            System.out.println("Prout");
        if (addressId == null)
            System.out.println("Chausette");
        if (persons.containsKey(personId)) {
            persons.get(personId).bind(addresses.get(addressId));
        }
    }
}
