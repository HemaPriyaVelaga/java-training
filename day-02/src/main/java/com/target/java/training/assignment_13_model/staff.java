package com.target.java.training.assignment_13_model;

public class staff extends person {
    private String school;
    private double pay;

    public staff()
    {

    }

    public staff(String name, String address, String school, double pay){

        super.setName(name);
        super.setAddress(address);
        setPay(pay);
        setSchool(school);
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        if(pay>0)
        this.pay = pay;

        else
            System.out.println("Invalid 0 or negative pay.");
    }

    @Override
    public String toString() {
        return "staff{ Person[" +
                "name='" + super.getName() +  '\'' +
                "address='" + super.getAddress() + "]"+  '\'' +
                "school='" + school + '\'' +
                ", pay=" + pay +
                '}';
    }
}
