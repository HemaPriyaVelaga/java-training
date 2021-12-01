package com.target.training.java.programs;

import java.util.Scanner;

public class helloworld {
    public static void main(String[] args) {
        System.out.println("Hello World! My first Java code!");
        System.out.println("Working again :)");
        double myheight = 5.05;
        System.out.println("My height is " + myheight + " ft" );

        // take input from keypad

        //System.in.read for single inputs
        //System.in is the keyboard

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter age");
        int age = sc.nextInt();
        System.out.println("Enter city");
        String city = sc.nextLine();
        System.out.printf("%s is %d years old and from %s", name, age, city);

        // After typing age and clicking enter, the enter is
        // Considered as a new input by default
        // Thats why the city has not been printed here

        // The solution is to write our own keyboard util class


    }
}
