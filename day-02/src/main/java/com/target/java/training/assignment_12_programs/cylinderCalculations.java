package com.target.java.training.assignment_12_programs;

import com.target.java.training.assignment_12_model.circle;
import com.target.java.training.assignment_12_model.cylinder;

public class cylinderCalculations {
    public static void main(String[] args) {
        circle[] circles = {
                new cylinder(12.34),
                new cylinder(12.34, 10.0),
                new cylinder(12.34, 10.0, "blue")
        };

        System.out.println("Area of circle of 1st cylinder is: " + circles[0].getArea() + " and Volume is: " + ((cylinder)circles[0]).getVolume());
        System.out.println("Area of circle of 2nd cylinder is: " + circles[1].getArea() + " and Volume is: " + ((cylinder)circles[1]).getVolume());
        System.out.println("Area of circle of 3rd cylinder is: " + circles[2].getArea() + " and Volume is: " + ((cylinder)circles[2]).getVolume());
    // ((cylinder)circles[0]).getVolume();
    // To access functions from subclass from super class
    }
}
