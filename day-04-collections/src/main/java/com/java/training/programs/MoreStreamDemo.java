package com.java.training.programs;

import com.java.training.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MoreStreamDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Vinod", 48, 5.8, "Bangalore"));
        people.add(new Person("Hema", 23, 5.0, "Hyd"));
        people.add(new Person("Hima", 16, 5.2, "Delhi"));
        people.add(new Person("Priya", 12, 4.8, "Kolkata"));
        people.add(new Person("Bindu", 33, 5.5, "Bangalore"));

        // List of names, age >=40, city = bangalore

        people.stream()
                .filter(p->p.getAge()>=40)
                .filter(p->p.getCity().equals("Bangalore"))
                .map(p->p.getName()) // If we comment this, it will display the entire person object
                //.collect(Collectors.toList()); // returns a new list
                .forEach(System.out::println);

        List <String> names = people.stream()
                .filter(p->p.getAge()>=30)
                .filter(p->p.getCity().equals("Bangalore"))
                .map(p->p.getName()) // If we comment this, it will display the entire person object
                .collect(Collectors.toList()); // returns a new list

        System.out.println(names);

    }
}
