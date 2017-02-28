package beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saradion on 17/11/16.
 */
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;
    private String street;

    @ManyToMany
    private List<Person> inhabitants;

    public Address() {
        inhabitants = new ArrayList<>();
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<Person> getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(List<Person> inhabitant) {
        this.inhabitants = inhabitant;
    }

    public void addInhabitant(Person inhabitant) {
        inhabitants.add(inhabitant);
    }
}
