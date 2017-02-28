package beans;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by saradion on 17/11/16.
 */
public class Address {
    private String city;
    private String street;
    private String id;

    public Address(String street, String city) throws NoSuchAlgorithmException {
        this.city = city;
        this.street = street;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        StringBuilder sb = new StringBuilder();
        for (byte b : digest.digest((street + city).getBytes(StandardCharsets.UTF_8))) {
            sb.append(String.format("%02X",b));
        }
        id = sb.toString();
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getId() {
        return id;
    }
}
