package org.example;


import org.example.lab1.employee;
import org.example.lab1.people;

public class Main {
    public static void main(java.lang.String[] args) {

        people Tom = new people.Builder()
        .withName("Tom")
        .withPhoneNumber(3806676)
        .withExp(35)
        .withCodeP(9529)
                .build();

        people Tom1 = new people.Builder("Tom").build();

        people jim = new people.Builder("jim", 23566, 84, 878784).build();
        System.out.println(Tom);
        System.out.println(Tom1);
        System.out.println(jim);

        System.out.println(Tom.hashCode());
        System.out.println(Tom.equals(Tom1));
        System.out.println(Tom1.equals(jim));

        employee sam = new employee("Sam", "Oracle");
        System.out.println(sam.toString());

        employee sam1 = new employee("Sam", "Apple", "director",15222);
        System.out.println(sam1.toString());

        System.out.println(sam1.equals(sam));
        System.out.println(sam.hashCode());



    }
}