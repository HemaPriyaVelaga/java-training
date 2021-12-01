package com.target.java.training.assignments.assignment15.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class MovablePoint implements Movable {

    // Instance variables with package access
    // Classes in same package can access them directly
    int x, y, xSpeed, ySpeed;


    @Override
    public void moveUp() {
        y += ySpeed;
    }

    @Override
    public void moveDown() {
        y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }
}
