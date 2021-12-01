package com.target.java.training.exceptions.programs;

import java.lang.reflect.Array;
import java.util.Arrays;

public class exceptionDemo {
    public static void main(String[] args) {
        //System.out.println("Exception demo Application");
        //System.out.println("args is" + Arrays.toString(args));

        try{
            String s1 = args[0];
            String s2 = args[1];

            int num = Integer.parseInt(s1);
            int den = Integer.parseInt(s2);

            int quotient = num/den;

            System.out.println("Quotient is " + quotient);
        }

        catch(Exception ex){
            System.out.printf("There was an error of type %s with message of %s\n",ex.getClass().getName(), ex.getMessage() );
        }
        System.out.println("End of Program");



    }
}
