package com.target.java.training.assignment_14_model;

public class Rectangle extends Shape{

    private double width = 1.0;
    private double length = 1.0;

    public  Rectangle()
    {

    }

    public Rectangle(double width, double length){
        setWidth(width);
        setLength(length);
    }

    public Rectangle(double width, double length, String color, boolean filled){
        setLength(length);
        setWidth(width);
        super.setColor(color);
        super.setFilled(filled);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width>=0)
        this.width = width;

        else
            System.out.println("Negative width invalid so setting default width");
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(length>=0)
        this.length = length;
        else
            System.out.println("Negative length invalid so setting default length.");
    }

    public double getArea(){
        return width*length;
    }

    public double getPerimeter(){
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle{ Shape[" +
                "Color='" + super.getColor() +  '\'' +
                "Filled='" + super.isFilled() + "]" +  '\'' +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}
