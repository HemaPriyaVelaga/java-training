package com.target.java.training.assignments.assignment15.programs;

import com.target.java.training.assignments.assignment15.model.Movable;
import com.target.java.training.assignments.assignment15.model.MovableCircle;
import com.target.java.training.assignments.assignment15.model.MovablePoint;
import com.target.java.training.assignments.assignment15.model.MovableRectangle;

public class MovingPoints {
    public static void main(String[] args) {

        System.out.println("\n\nMOVABLE POINT:\n");
        Movable m1 = new MovablePoint(5, 6, 10, 15);     // upcast
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);

        System.out.println("\n\nMOVABLE CIRCLE:\n");
        Movable m2 = new MovableCircle(1, 2, 3, 4, 20);  // upcast
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);

        // The top left rectangle moves only down and right
        // Bottom right rectangle moves only top and left
        System.out.println("\n\nMOVABLE RECTANGLE:\n");
        Movable m3 = new MovableRectangle(1, 2, 3, 4, 25, 35);  // upcast
        System.out.println(m3);
        m3.moveUp();
        System.out.println(m3);

    }
}
