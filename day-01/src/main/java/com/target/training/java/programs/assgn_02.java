package com.target.training.java.programs;
import java.util.Scanner;
public class assgn_02 {
    static boolean isPrimeNumber(int num) {
        // do stuff here
        if(num<=1){
            return false;
        }

        if(num%2==0){
            return false;
        }

        for (int i=2; i*i<=num;i++)
        {
            if(num%i==0) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        int num = sc.nextInt();

        if(isPrimeNumber(num)){
            System.out.println("The number "+num+" is Prime");
        }
        else
        {
            System.out.println("The number "+num+" is NOT prime");
        }
    }
}
