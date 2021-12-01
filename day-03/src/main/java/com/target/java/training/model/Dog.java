package com.target.java.training.model;

public class Dog extends Animal {
    @Override
    public void talk() {
        //super.talk();
        System.out.println("Dog Barks!");
    }

    public void wagTail()
    {
        System.out.println("Dog is wagging its tail");
    }
}
