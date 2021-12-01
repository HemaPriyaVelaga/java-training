package com.target.training.java.programs;

import java.util.Scanner;

public class assgn_07 {
    // in main function, vary n from 0 to 10
    public static int signOne(int n) {

        if (n % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
        //return 1;
    }

    public static double valX(int n, int x) {
        double prodX = x;
        for (int i = 1; i <= 2 * n - 1; i++) {
            prodX *= x;
        }

        return prodX;
    }

    public static long denFactorial(int n) {
        long fact = 1;
        if (n <= 1) {
            fact = 1;
        } else {
            for (long i = 2; i <= 2*n-1; i++) {
                fact *= i;
            }
        }
        return fact;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        int x = sc.nextInt();
        double angle = 0.0;
        for(int n=1;n<=10;n++){
            angle += ((signOne(n)*valX(n, x))/denFactorial(n));
        }

        System.out.println("The angle for given x is: "+angle);
    }

}