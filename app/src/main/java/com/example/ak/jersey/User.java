package com.example.ak.jersey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ak on 2017. 03. 16..
 */

public class User {
    @SerializedName("email")
    String email;
    @SerializedName("firstName")
    String firstName;
    @SerializedName("id")
    int id;
    @SerializedName("lastName")
    String lastName;
    @SerializedName("password")
    String password;


    public User(String email, String firstName, int id, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
