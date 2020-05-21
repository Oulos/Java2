package ru.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class PhoneBook {

    private static HashMap<String, Integer> phone = new HashMap<String, Integer>();
    private static HashMap<String, String> mail = new HashMap<String, String>();

    public static void searchPhoneNumber (String lastName) {
        //ArrayList<Integer> phoneNumber = new ArrayList<Integer>();
        HashSet<Integer> phoneNumber = new HashSet<Integer>();
        for (int i = 0; i < Person.getAllPerson().size(); i++) {
            phone.put(Person.getAllPerson().get(i).getLastName(), Person.getAllPerson().get(i).getPhoneNumber());
            if (phone.containsKey(lastName))
                phoneNumber.add(phone.remove(lastName));
        }
        System.out.println("Результат поиска телефонного номера по фамилии " + lastName + ": " + phoneNumber);
    }

    public static void searchEmail (String lastName) {
        //ArrayList<String> email = new ArrayList<String>();
        HashSet<String> email = new HashSet<String>();
        for (int i = 0; i < Person.getAllPerson().size(); i++) {
            mail.put(Person.getAllPerson().get(i).getLastName(), Person.getAllPerson().get(i).getEmail());
            if (mail.containsKey(lastName))
                email.add(mail.remove(lastName));
        }
        System.out.println("Результат поиска адреса электронной почты по фамилии " + lastName + ": " + email);
    }

}
