package com.java.training.programs;

import com.java.training.entity.Customer;
import com.java.training.entity.Gender;

public class enumDemo {
    public static void main(String[] args) {
        Customer c1 = new Customer();

        c1.setName("Vinod");
        c1.setGender(Gender.MALE);

        System.out.println(c1);

        if(c1.getGender()==Gender.MALE){
            System.out.println("MALE");
        }
        else{
            System.out.println("FEMALE");
        }
    }
}
