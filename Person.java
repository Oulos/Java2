package ru.hw3;

import java.util.ArrayList;
import java.util.Arrays;

public class Person {

    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private static ArrayList<Person> allPerson = new ArrayList<Person>();

    public Person (String firstName, String lastName, int phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = this.firstName.charAt(0) + "." + this.lastName + "@.example.com";
        allPerson.add(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public static ArrayList<Person> getAllPerson() {
        return allPerson;
    }

}
