package com.target.java.training.assignments.assignment16.programs;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class IntegerApp {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input, no = "NO";
        int n , intcount = 0, inputcount = 0, nonintcount=0;
        int inputSum = 0;
        Vector<Integer> numbers = new Vector<>();
        Vector<String > characters = new Vector<>();

        while(true) {

            try {
                System.out.print("Enter a Number: ");
                n = s.nextInt();

                intcount ++;
                inputcount++;
                inputSum+=n;
                numbers.add(n);
            }
            catch (InputMismatchException ex){
                System.out.println("Non - integer number entered");
                s.nextLine();
                continue;
            }
            s.nextLine();

            try {
                System.out.print("Do you wish to continue? (if input is NO, the program will stop): ");
                input = s.nextLine();
                //s.nextLine();
                inputcount++;
                nonintcount++;
                //System.out.println("Entered input is:  " + input);
                if(input.trim().equals(no)){
                    //System.out.println("Entered if statement....");
                    break;
                }
                else
                {
                    //System.out.println("Entered ELSE statement.....");
                    characters.add(input);

                }

            }
            catch (Exception ex){
                System.out.println("No line found");
            }


        }

        System.out.println("\nNumber of Inputs = " + inputcount);
        System.out.println("Number of Integer Inputs: " + intcount);
        System.out.println("Number of non-integer inputs: " + nonintcount);
        System.out.println("Sum of all Integer inputs = " + inputSum);
        System.out.print("The integer inputs = ");
        for(int i=0;i<numbers.size();i++)
        {
            System.out.print(numbers.get(i) +" ");
        }
        System.out.print("\nThe non-integer inputs = ");
        for(int i=0;i<characters.size();i++)
        {
            System.out.print(characters.get(i) + " ");
        }

        //System.out.println("END OF THE PROGRAM");


    }
}
