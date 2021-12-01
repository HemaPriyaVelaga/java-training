package com.java.training.programs;

import com.java.training.model.circle;

// Consider a generic circle class where the radius can be either
// a double or an int based on that specified by user

public class GenericsDemo {
    public static void main(String[] args) {
        circle <Integer> c1int = new circle<Integer>();
        c1int.setRadius(1);

        circle <Double> c2double = new circle<>();
        c2double.setRadius(12.43);

        circle <String> c3string = new circle<>();
        c3string.setRadius("two");

        System.out.println(c1int.getRadius() + ", " + c2double.getRadius() + ", " + c3string.getRadius());
    }
}
