package com.target.java.training.model;

public class Cat extends Animal {
    @Override
    public void talk() {
        //super.talk();
        System.out.println("Cat Meows!");
    }

    public void phurr(){
        System.out.println("Cat is phurring !!");
    }
}
