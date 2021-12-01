package com.target.java.training.exceptions.programs;

import com.target.java.training.exceptions.model.EmptyNullNameException;
import com.target.java.training.exceptions.model.InvalidIDException;
import com.target.java.training.exceptions.model.employee;

public class customExceptionDemo {
    public static void main(String[] args) {
        employee e1;

        e1 = new employee();
        try {
            e1.setName(" ");
            e1.setId(0);
            e1.setSalary(1000);
        }

        catch (InvalidIDException ex){
            //System.out.println("Give an ID greater than 0");
        }

        catch (EmptyNullNameException ex){
            //System.out.println("Give a non null and non empty name");
        }

    }
}
