package com.target.java.training.assignment_13_model;

public class student extends person {
    private String program;
    private int year;
    private double fee;

    public student(){

    }

    public student(String name, String address, String program, int year, double fee)
    {
            super.setName(name);
            super.setAddress(address);
            setProgram(program);
            setYear(year);
            setFee(fee);
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year>0)
        this.year = year;

        else
            System.out.println("Invalid year");
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        if(fee>=0)
        this.fee = fee;

        else
            System.out.println("Negative fee invalid");
    }

    @Override
    public String toString() {
        return "student{ Person[" +
                "name='" + super.getName() +  '\'' +
                "address='" + super.getAddress() + "]"+  '\'' +
                "program='" + program + '\'' +
                ", year=" + year +
                ", fee=" + fee +
                '}';
    }
}
