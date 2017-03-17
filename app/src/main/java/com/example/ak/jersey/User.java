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

    public User(String email) {

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
}
