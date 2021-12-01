package com.target.java.training.model;

public class person {
    private String name;
    private int age;
    private double height;

    public person(){
        //default constructor given by compiler when there are no
        // other constructor in the class

        // It is a good practice to add this
        // Unless not wanted explicitly
    }

    // Overloaded or parameterised constructor
    public person(String name, int age, double height) {
        this.name = name;
        setAge(age); // We can do this too! in case there are any conditions to be checked
        this.height = height;
    }

    //Encapsulation using the below 3 functions
    public void setName(String name){
        this.name = name;

    }

    public void setAge(int age){
        if(age>=0 && age<=100)
            this.age = age;
    }

    public void setHeight(double height){
        if(height>0 && height<8)
            this.height = height;
    }
@Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
//Original to string function gives the address output of the object when printed

    public void print(){
        System.out.println(name + " " + age + "yrs " + height + "ft.");
    }
}
