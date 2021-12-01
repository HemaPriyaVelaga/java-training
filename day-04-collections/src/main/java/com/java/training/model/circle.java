package com.java.training.model;

// that T can be replaces by any name like Hema or Cat etc
// It doesnt matter but for technical purposes it is good to use T
// We can pass <T1, T2> if we want different types for different variables
public class circle<T> {

    private T radius;

    public T getRadius() {
        return radius;
    }

    public void setRadius(T radius) {
        this.radius = radius;
    }
}
