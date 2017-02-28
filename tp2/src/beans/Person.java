package beans;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saradion on 17/11/16.
 */
public class Person {
    private String lastName;
    private String firstName;
    private List<Address> addresses;
    private String id;

    public Person(String lastName, String firstName) throws NoSuchAlgorithmException {
        this.lastName = lastName;
        this.firstName = firstName;
        addresses = new ArrayList<>();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        StringBuilder sb = new StringBuilder();
        for (byte b : digest.digest((lastName + firstName).getBytes(StandardCharsets.UTF_8))) {
            sb.append(String.format("%02X",b));
        }
        id = sb.toString();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Address> getAddresses() {
        return new ArrayList<>(addresses);
    }

    public String getId() {
        return id;
    }

    public void bind(Address address) {
        addresses.add(address);
    }
}
