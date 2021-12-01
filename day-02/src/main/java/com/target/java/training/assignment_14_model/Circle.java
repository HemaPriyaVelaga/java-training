package com.target.java.training.assignment_14_model;

public class Circle extends Shape {
    private double radius = 1.0;

    public Circle(){

    }

    public Circle(double radius)
    {
        setRadius(radius);
    }

    public Circle(double radius, String color, boolean filled)
    {
        setRadius(radius);
        super.setColor(color);
        super.setFilled(filled);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {

        if(radius>0)
        this.radius = radius;

        else
            System.out.println("Invalid radius given so setting to default value. ");
    }

    public double getArea(){
        return 3.14 * radius * radius;
    }

    public double getPerimeter(){
        return 2 * 3.14 * radius;
    }

    @Override
    public String toString() {
        return "Circle{ Shape[" +
                "Color='" + super.getColor() +  '\'' +
                "Filled='" + super.isFilled() + "]" + '\'' +
                "radius=" + radius +
                '}';
    }
}
