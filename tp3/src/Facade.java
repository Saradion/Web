import beans.Address;
import beans.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by saradion on 22/11/16.
 */
@Stateless(name = "Facade")
public class Facade implements FacadeRemote, FacadeLocal {

    @PersistenceContext(unitName = "MaPU")
    private EntityManager em;

    @Override
    public void addPerson(String lname, String fname) {
        Person newPerson = new Person(lname, fname);
        em.persist(newPerson);
    }

    @Override
    public void addAddress(String street, String city) {
        Address address = new Address(city, street);
        em.persist(address);
    }

    @Override
    public Collection<Person> listePersonnes() {
        TypedQuery<Person> req = em.createQuery("select p from Person p", Person.class);
        return req.getResultList();
    }

    @Override
    public Collection<Address> listeAddress() {
        TypedQuery<Address> req = em.createQuery("select a from Address a", Address.class);
        return req.getResultList();
    }

    @Override
    public void associer(int personId, int addressId) {
        // Avec un OneToMany bidirectionnel
        // em.find(Address.class, addressId).setInhabitant(em.find(Person.class, personId));

        // Avec un ManyToMany bidirectionnel
        em.find(Address.class, addressId).addInhabitant(em.find(Person.class, personId));

        // Avec un OneToOne birectionnel ... C'est pareil que le OneToMany mais pour le lolz on va le faire dans l'autre
        // sens :D
        // em.find(Person.class, personId).setAddress(em.find(Address.class, addressId));
    }
}
