package com.target.java.training.programs;

import com.target.java.training.model.circleInterface;
import com.target.java.training.model.shape;
import com.target.java.training.model.triangle;
import org.w3c.dom.css.CSSImportRule;

public class polymorphismUsingInterfaces {

    public static void main(String[] args) {

        shape Shape;
        // An object of shape cant be created but can be realised
        // using object of a class that implements the interface

        circleInterface c1 = new circleInterface(12.34);
        triangle t1 = new triangle(12, 34);

        System.out.println("The shape is " + c1.getName() + " and area is " + c1.getArea());
        System.out.println("The shape is " + t1.getName() + " and area is " + t1.getArea());

    }
}
