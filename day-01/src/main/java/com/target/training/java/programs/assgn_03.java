package com.target.training.java.programs;

public class assgn_03 {
    public static void sortThreeNumbers(int a, int b, int c) {
        // do stuff here'
        if(a>b){
            if(b>c)
            {
                System.out.println(c+", "+ b+", "+ a);

            }
            else
            {
                if(a>c){
                    System.out.println(b+", "+ c+", "+ a);
                }
                else{
                    System.out.println(b+", "+ a+", "+ c);
                }
            }
        }

        else if(b>a){
            if(a>c)
            {
                System.out.println(c+", "+ a+", "+ b);
            }
            else
            {
                if(b>c){
                    System.out.println(a+", "+ c+", "+ b);
                }

                else{
                    System.out.println(a+", "+ b+", "+ c);
                }
            }
        }

        else if (c>a){
            if(a>b)
            {
                System.out.println(b+", "+ a+", "+ c);
            }
            else
            {
                if(c>b){
                    System.out.println(a+", "+ b+", "+ c);
                }

                else{
                    System.out.println(a+", "+c+", "+b);
                }
            }
        }

        return;
    }

    public static void main(String[] args) {
        sortThreeNumbers(10, 2, 1);
        sortThreeNumbers(20, 10, 1);
        sortThreeNumbers(2, 10, 11);
        //sortThreeNumbers(10, 2, 1);
    }
}
