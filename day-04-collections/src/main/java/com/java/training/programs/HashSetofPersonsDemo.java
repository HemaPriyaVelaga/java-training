package com.java.training.programs;

import com.java.training.entity.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetofPersonsDemo {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        Person p;
        p = new Person("Vinod", 48, 5.8, "Bangalore");
        System.out.println(p.hashCode());
        people.add(p);
        p = new Person("Vinod", 23, 5.8, "Bangalore");
        System.out.println(p.hashCode());
        people.add(p);
        p = new Person("Vinod", 48, 5.8, "Hyderabad" );
        System.out.println(p.hashCode());
        people.add(p);
        p = new Person("Hema", 48, 5.8, "Bangalore");
        System.out.println(p.hashCode());
        people.add(p);

        p = new Person("Vinod", 48, 5.8, "Hyderabad" );
        System.out.println(p.hashCode());

        // if the person class does not implement the compareTo<person>
        // Here, the set is checking the hashcode for every element.
        // If the hash code is different, it adds to the set
        // But it doesnt check the values of the object

        // Here, each new object has a different hashcode even if it has
        // same values of another object


        System.out.println("people.size() is " + people.size());

 //       Iterator<Person> it = people.iterator();

//        while (it.hasNext()){
//            Person p1 = it.next();
//            System.out.println(p1);
//
//        }
        printPeople(people);

        //printPeople(people);
    }

    static void printPeople(Set<Person> people) {

        for (Person p : people) {
            System.out.println(p);
        }
    }
}
