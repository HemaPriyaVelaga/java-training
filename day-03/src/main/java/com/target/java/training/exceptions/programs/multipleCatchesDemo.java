package com.target.java.training.exceptions.programs;

import javax.crypto.AEADBadTagException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class multipleCatchesDemo {

    public static void main(String[] args) {

        try{
            String s1 = args[0];
            String s2 = args[1];

            int num = Integer.parseInt(s1);
            int den = Integer.parseInt(s2);

            int quotient = num/den;

            System.out.println("Quotient is " + quotient);
        }

        catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Expected 2 integer inputs but got " + Arrays.toString(args));

        }

//        catch (NumberFormatException e){
//            System.out.println("Expected 2 integers but received " + Arrays.toString(args));
//        }

        catch (ArithmeticException e){
            System.out.println("Cant divide by zero");
        }

        catch (Exception e){
            System.out.println("Something went wrong");
        }

        System.out.println("End of Program");

        }
//        catch(Exception ex){
//            System.out.printf("There was an error of type %s with message of %s\n",ex.getClass().getName(), ex.getMessage() );
//        }


    }
