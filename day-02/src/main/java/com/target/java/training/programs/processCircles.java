package com.target.java.training.programs;

import com.target.java.training.model.circle;

public class processCircles {
    public static void main(String[] args) {
        circle c1 = new circle(); //16B reserved in heap
        c1.radius = 2.5;

        circle c2 = new circle(); //16B reserved in heap
        c2.radius = 3.5;

        // c1 and c2 are references to the two objects
        // the references are stored in stack


        c1.printArea();
        c2.printArea();

        System.out.println("Public static variable pi of circle class: " + circle.pi);
        // If pi is not mentioned static, we can call it using c1.pi

    }
}
