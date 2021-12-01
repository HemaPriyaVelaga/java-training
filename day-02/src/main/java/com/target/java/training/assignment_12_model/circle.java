package com.target.java.training.assignment_12_model;

public class circle {
    private double radius = 1.0;
    private String color = "red";

    public circle(){
        //Empty Constructor
    }

    public circle(double radius){
        setRadius(radius);
    }

    public circle(double radius, String color){

        setRadius(radius);
        setColor(color);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius >=0 ){
            this.radius = radius;
        }
        else{
            System.out.println("negative radius doesnt exist! So default value allocated.");
        }
    }

    /*public  double getVolume()
    {

        System.out.println("In getVolume of SUPER class");
        return 0.0;
    }*/

    // The above function is a wrong practice.
    // We should not modify super class for just using functions in sub classes


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea()
    {
        return 3.14 * this.radius * this.radius;
    }

    @Override
    public String toString() {
        return "circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
