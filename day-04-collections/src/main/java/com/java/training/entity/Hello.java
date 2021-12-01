package com.java.training.entity;

public interface Hello {
    public void sayHello(String name);
    default public void sayHello(String name, String city){

    }
}
