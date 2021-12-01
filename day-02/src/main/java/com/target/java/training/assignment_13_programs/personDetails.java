package com.target.java.training.assignment_13_programs;

import com.target.java.training.assignment_13_model.person;
import com.target.java.training.assignment_13_model.staff;
import com.target.java.training.assignment_13_model.student;

public class personDetails {

    public static void main(String[] args) {


        person[] people = {
                new student("Shyam", "Bangalore, Karnataka", "Java fundamentals", 2010, 4500.0),
                new staff("Anand", "Bangalore, Karnataka", "Delhi Public school", 35000.0),
                new staff("Umesh", "Bangalore, Karnataka", "National Public school", 42000.0),
                new student("Suresh", "Hassan, Karnataka", "Java fundamentals", 2012, 4750.0),
                new student("Kiran", "Vasco, Goa", "Reactjs", 2017, 12500.0)
        };

        for (int i = 0; i < 5; i++) {
            System.out.println("Person " + i + " details are: " + people[i].toString());
        }
    }
}
