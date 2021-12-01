package com.target.training.java.programs;

public class assgn_04 {

    public static boolean checkPrime(int num){
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

    public static int sumOfPrimes(int from, int to) {
        // do stuff here
        if(from>=to){
            System.out.println("Invalid Range");
            return 0;
        }
        int primeSum=0;
        for (int i=from; i<=to;i++)
        {
            if(checkPrime(i)){
                primeSum+=i;
            }

        }
        return primeSum;
    }

    public static void main(String[] args) {

        System.out.println(sumOfPrimes(1,10));
        System.out.println(sumOfPrimes(4,13));

    }
}
