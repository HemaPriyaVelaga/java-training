package com.java.training.programs;

import com.java.training.entity.Person;

import java.util.*;

public class SortingPersonsDemo {
    static class AgeComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge()<o2.getAge() ? -1:1;
        }
    }
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Vinod", 48, 5.8, "bangalore"));
        people.add(new Person("Hema", 23, 5.8, "Hyd"));
        people.add(new Person("Hima", 16, 5.8, "Delhi"));
        people.add(new Person("Priya", 12, 5.8, "Kolkata"));

        printPeople(people);
        Collections.sort(people);

        printPeople(people);


        Collections.sort(people, new AgeComparator());
        printPeople(people);

        // Writing an anonymous object without having to create a new class
        Collections.sort(people, new Comparator<Person>(){
            public int compare(Person p1, Person p2){
                return p1.getHeight()<=p2.getHeight()? -1:1;
            }
        });
        // We can write the above to compare cities also
        // new Comparator<Person>(){} = Anonymous Class if added {} i.e.; class without a name
        printPeople(people);


        Collections.sort(people, ( p1,  p2) -> p1.getCity().compareTo(p2.getCity())<=0?-1:1);

        printPeople(people);

       // Collections.sort(people, (p1,p2) ->p1.);
    }

    //compare abstract function inbuilt
    static void printPeople(List<Person> people){

        for(Person p: people){
            System.out.println(p);
        }
    }
}
