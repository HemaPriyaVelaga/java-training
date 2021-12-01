package com.target.training.java.programs;

import java.util.Scanner;

public class assgn_01 {
    static boolean isValidDate(int year, int month, int day) {
        // do stuff here
        if(month>12)
        {
            return false;
        }

        if(day>31)
        {
            return false;
        }

        switch (month)
        {
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30)
                {
                    return false;
                }
                break;
            case 2:
                if((year%4 == 0) && !(year%100==0) || (year%400==0)){
                    if(day>29){
                        return false;
                    }
                    break;
                }

                else
                    {
                        if(day>28){
                            return false;
                        }
                        break;
                    }
                //break;
            default:
                break;

        }

        return true;
    }

    public static void main(String[] args) {
        //int year, month, day;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter year: ");
        int year = sc.nextInt();

        System.out.println("Enter month: ");
        int month = sc.nextInt();

        System.out.println("Enter day: ");
        int day = sc.nextInt();
        System.out.println("Is given date valid? ");
        System.out.println(isValidDate(year, month, day));


    }

}
