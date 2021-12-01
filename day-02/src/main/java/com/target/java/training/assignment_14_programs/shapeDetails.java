package com.target.java.training.assignment_14_programs;

import com.target.java.training.assignment_14_model.Circle;
import com.target.java.training.assignment_14_model.Rectangle;
import com.target.java.training.assignment_14_model.Shape;
import com.target.java.training.assignment_14_model.Square;

public class shapeDetails {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(3.5),
                new Circle(),
                new Rectangle(),
                new Rectangle(10.0, 20.0),
                new Rectangle(100.0, 200.0, "Red", true),
                new Rectangle(3.0, 4.0, "Blue", false),
                new Square(),
                new Square(5.0),
                new Square(5.0, "Green", false),
                new Square(8.0, "Yellow", false),
        };

        for(int i=0;i<10;i++)
        {
            System.out.println("Shape "+ i + " details : " + shapes[i].toString());
        }

        //System.out.println();

    }
}
