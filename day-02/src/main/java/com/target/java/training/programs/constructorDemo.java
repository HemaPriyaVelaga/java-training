package com.target.java.training.programs;

import com.target.java.training.model.person;

public class constructorDemo {
    public static void main(String[] args) {
        person p1 = new person();
        person p2 = new person("Arun", 47, 5.6);

        System.out.println("Uses defualt constructor: " + p1);
        System.out.println("Uses parameterised constructor: " + p2);
    }
}
