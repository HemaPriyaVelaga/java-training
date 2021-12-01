package com.java.training.programs;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> names= new HashSet<>();
        //Set<String> names= new LinkedHashSet<>();
        //Set<String> names= new TreeSet<>();

        names.add("Hema");
        names.add("Priya");
        names.add("Hima");
        names.add("Bindu");
        names.add("ANil");
        names.add("Venu");
        names.add("Kavitha");
        names.add("Gopal");
        System.out.println("Size = " + names.size());
        System.out.println("Content = " + names);
        /// No guarantee for the order/sequence of elements for HashSet
        // For linked hash set, order is maintained
        // For Tree Set, alphabetical order is maintained
        // hashed datasets depend on hash code

    }
}
