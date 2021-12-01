package com.target.java.training.assignments.assignment15.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class MovableRectangle implements Movable {

    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed){
        topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }


    @Override
    public void moveUp() {
        //topLeft.y += topLeft.ySpeed; //topleft doesnt move up
        bottomRight.y += bottomRight.ySpeed;
    }

    @Override
    public void moveDown() {
        topLeft.y -= topLeft.ySpeed;
        //bottomRight.y -= bottomRight.ySpeed; // bottom right doesnt move down
    }

    @Override
    public void moveLeft() {
       // topLeft.x -= topLeft.xSpeed; // topleft doesnt move any more left;
        bottomRight.x -= bottomRight.xSpeed;
    }

    @Override
    public void moveRight() {
        topLeft.x += topLeft.xSpeed;
        //bottomRight.x += bottomRight.xSpeed; bottom right doesnt move right;
    }
}
