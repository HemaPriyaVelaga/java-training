package com.java.training.programs;

import com.java.training.entity.Person;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetOfPersonsDemo {
    public static void main(String[] args) {
        Set<Person> people = new TreeSet<>(); // does not use hashCode() or equals() to check for duplicates
        // instead, uses Comparable interface.
        // The element class must implement Comparable interface, and provide the compareTo method implementation

        people.add(new Person("Vinod", 48, 5.8, "Bangalore"));
        people.add(new Person("Arunima", 20, 5.5, "Bangalore"));
        people.add(new Person("Naveen", 48, 5.8, "Bangalore"));
        people.add(new Person("Arun", 48, 5.8, "Bangalore"));
        people.add(new Person("Ramesh", 48, 5.8, "Bangalore"));
        people.add(new Person("Mahesh", 48, 5.8, "Bangalore"));
        people.add(new Person("Arunima", 18, 5.3, "Bangalore"));
        people.add(new Person("Arunima", 18, 5.3, "Bangalore"));

        // java 1.5 onwards; wrapper over iterator
        for (Person p : people) {
            System.out.println(p);
        }

    }
}
