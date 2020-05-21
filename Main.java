package ru.hw3;

import java.util.*;

public class Main {

    private static ArrayList<String> listOfWords (String[] a) {
        ArrayList<String> words = new ArrayList<String>();
        words.add(0, a[0]); //я тут сделал перестраховку: если мне надо искать повторы, а список пустой, то возможно получу на выходе ошибку, а нулевой элемент по-дефолту уникальынй
        for (int i = 1; i < a.length; i++) {
            String tmp = null;
            for (int j = 0; j < words.size(); j++) {
                if (words.get(j).equals(a[i]))
                    tmp = a[i];
            }
            if (!a[i].equals(tmp))
                words.add(a[i]);
        }

        return words;
    }

    private static LinkedHashSet<String> anotherListOfWords (String[] a) {
        LinkedHashSet<String> words = new LinkedHashSet<String>();
        /*for (int i = 0; i < a.length; i++) {
            words.add(a[i]);
        }*/
        words.addAll(Arrays.asList(a)); //выше я зарядил еще один цикл, самый простой, но идея мне его выделила и предложила уложить добавление в одну строку
        return words;
    }

    private static LinkedHashMap<String, Integer> valueOfWords (String[] a) {
        LinkedHashMap<String, Integer> words = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < a.length; i++) {
            int v = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i].equals(a[j]))
                    v++;
            }
            words.put(a[i], v);
        }

        return words; //если в этом задании подразумевался цикл foreach, то я не въехал, как его использовать, сделал как смог, вроде получилось
    }

    public static void main (String[] args) {

        String[] text = {"one", "two", "three", "four", "five",
                        "alpha", "beta", "gamma", "zeta", "probe",
                        "star", "four", "hell", "alpha", "mouse",
                        "phone", "star", "board", "zeta", "window",
                        "four", "pepper", "gamma", "pencil", "gamma",
                        "apple", "board", "car", "four", "dog",
                        "alpha", "star", "book", "clock", "alpha"};
        ArrayList<String> words = listOfWords(text);
        LinkedHashSet<String> words2 = anotherListOfWords(text);
        LinkedHashMap<String, Integer> words3 = valueOfWords(text);
        System.out.println(words);
        System.out.println(words2);
        //В итоге, оба списка одинаковые
        System.out.println(words3);

        Person person1 = new Person("John", "Smith", 5551342);
        Person person2 = new Person("Teador", "Smith", 5553627);
        Person person3 = new Person("Thomas", "Anderson", 5550000);
        Person person4 = new Person("Sarah", "Connor", 5551047);
        Person person5 = new Person("Bruce", "Willis", 5552690);
        Person person6 = new Person("Jessica", "Willis", 5555418);


        PhoneBook.searchPhoneNumber("Smith");
        PhoneBook.searchPhoneNumber("Willis");
        PhoneBook.searchEmail("Willis");
        PhoneBook.searchEmail("Smith");
        PhoneBook.searchEmail("Connor");


    }

}
