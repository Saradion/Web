package beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saradion on 17/11/16.
 */
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lastName;
    private String firstName;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "inhabitants")
    private List<Address> addresses;

    public Person(String lastName, String firstName) {
        this();
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
