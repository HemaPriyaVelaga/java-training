package com.target.java.training.assignment_12_model;

public class cylinder extends circle {
    private double height = 1.0;

    public cylinder(){

    }

    public cylinder(double radius)
    {
        super.setRadius(radius);
    }

    public cylinder(double radius, double height)
    {
        super.setRadius(radius);
        setHeight(height);
    }

    public cylinder(double radius, double height, String color)
    {
        super.setColor(color);
        super.setRadius(radius);
        setHeight(height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height>=0)
        {
            this.height = height;
        }
        else{
            System.out.println("Height cant be negative so using default height");
        }
    }


    public  double getVolume(){
        System.out.println("In getVolume of SubClass");
        return 3.14 * super.getRadius() * super.getRadius() * height;
    }



}
