package com.target.java.training.assignment_14_model;

public class Square extends Rectangle{

    public Square()
    {

    }

    public Square(double side){
        setSide(side);
    }

    public Square (double side, String color, boolean filled){
        setSide(side);
        super.setColor(color);
        super.setFilled(filled);
    }

    public double getSide(){
        return super.getWidth(); // Note: We are setting width and height to same value in the subsequent setter functions
    }

    public void setSide(double side){
        setLength(side);
        setWidth(side);
    }

    public void setWidth(double side){
        super.setWidth(side);
    }

    public void setLength(double side){
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "Square{ " + super.toString() + "}";
    }
}
