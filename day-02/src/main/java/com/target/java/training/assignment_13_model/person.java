package com.target.java.training.assignment_13_model;

public class person {
    private String name;
    private String address;

    public person()
    {

    }

    public person(String name, String address){
        setAddress(address);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
