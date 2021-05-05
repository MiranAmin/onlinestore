package onlineshop.entities.impl;

import onlineshop.entities.User;

public class DefaultUser implements User {

    private static int counter =0;

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    {
        id=counter++;
    }

    public DefaultUser(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "DefaultUser{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setEmail(String newEmail) {
        email = newEmail;
    }

    @Override
    public int getId() {
        return id;
    }

    void clearState() {
        counter=0;
    }
}
