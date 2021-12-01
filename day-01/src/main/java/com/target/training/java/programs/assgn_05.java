package com.target.training.java.programs;
import java.util.Scanner;

public class assgn_05 {
    public static void main(String[] args) {
        // index starts from 0
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        int num = sc.nextInt();

        int prev = 0;
        int curr = 1;
        int temp =0;
        int fib=1;
        if(num==0){
            System.out.println("The nth fibonacci number (index starts from 0) is "+0);
        }
        else if(num==1 || num == 2)
        {
            System.out.println("The nth fibonacci number (index starts from 0) is "+1);
        }

        else if(num>2) {
            for (int i = 1; i < num; i++) {
                //temp = fib;
                fib = prev + curr;

                prev = curr;
                curr = fib;
                //System.out.println(fib);

            }

            System.out.println("The nth fibonacci number (index starts from 0) is " + fib);
        }
    }
}
