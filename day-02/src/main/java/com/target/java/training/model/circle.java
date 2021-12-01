package com.target.java.training.model;

public class circle {
    public double radius;
    public static double pi = 3.1416;

    // If no static in pi, whenever any object is created
    // a new memory will be allocated to store pi value
    // So a lot of heap memory will be wasted

    // If static is mentioned, memory will be allocated to pi
    // only one time and every new object can use it

    // To access the static variable pi for an object, type circle.pi, not c1.pi.
    // It wil throw an error

    public void printArea(){
        double area = pi * radius * radius;
        System.out.println("The area of circle with "+radius + " is " + area);
    }
}
