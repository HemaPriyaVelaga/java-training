package com.target.java.training.assignments.assignment17.programs;

import com.target.java.training.assignments.assignment17.model.InvalidMonthException;
import com.target.java.training.assignments.assignment17.model.InvalidYearException;
import com.target.java.training.assignments.assignment17.utils.KeyBoardUtils;

public class Calendar {


    public static void main(String[] args) {

        int month;
        int year;

        while(true)
        {
            try {
                    month = KeyBoardUtils.getInt("Enter Month : ");
                    year = KeyBoardUtils.getInt("Enter Year (YYYY): ");

                    if (month <= 0 || month > 12) {
                        throw new InvalidMonthException("Invalid input. Please enter a valid month.");
                    }
                    else if (year < 1800 || year >= 3000)
                    {
                        throw new InvalidYearException("Invalid year. Enter year between 1800 to 3000. ");
                    }
                    else
                    {
                        break;
                    }

            }

            catch (Exception e) {
                    System.out.println();
            }

        }

        printMonthHeading(month, year);
        printMonthCalendar(month, year);

    }


    static String getMonthName(int month)
    {
        switch (month){
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Default" ;

        }
    }



    static void printMonthHeading(int month, int year)
    {

        String str = "------------------------------------";
        System.out.println("     " + getMonthName(month) + "   " + year);
        System.out.println(str);
        System.out.println("  Sun  Mon  Tue  Wed  Thu  Fri  Sat");
        System.out.println(str);

    }


    private static void printMonthCalendar(int month, int year)
    {
        int startDay = getStartDayofMonth(month, year);
        int numDays = getNumDays(month, year);

        int i=0;
        for (i = 0; i < startDay; i++)
        {
            System.out.print("     ");
        }

        for (i = 1; i <= numDays; i++)
        {
            if (i < 10) {
                System.out.print("    " + i);
            }
            else
            {
                System.out.print("   " + i);
            }
            if ((i + startDay) % 7 == 0)
            {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("------------------------------------");

    }


    // Start day of 1st that month in the given year
    private static int getStartDayofMonth(int month, int year)
    {
        int startDayOfJan1800 = 3; // Wednesday
        int totalNumOfDays = getTotalDays(month, year);

        return (startDayOfJan1800 + totalNumOfDays) % 7;

    }


    // Get total number of days from year 1800 January to the month prior to given month
    private static int getTotalDays(int month, int year)
    {
        int total = 0;
        // From Jan 1st 1800 to  Dec 31st of the year before given year
        for(int i=1800; i<year;i++)
        {
            if(isLeapYear(i))
            {
                total+=366;
            }
            else
            {
                total+=365;
            }
        }

        // From Jan 1 of given year to month end of that before given month
        for(int i = 1;i<month;i++)
        {
            total+= getNumDays(i, year);
        }

        return total;
    }

    // Get number of days in the given month in the given year
    private static int getNumDays(int month, int year)
    {
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: return 31;

            case 4:
            case 6:
            case 9:
            case 11: return 30;

            case 2: return isLeapYear(year)? 29: 28;
            default:return 0;
        }
    }

    // Check whether the given year is a leap year or not!
    private static boolean isLeapYear(int year){

        return (year % 400 == 0 )|| (year % 4 == 0 && year % 100 != 0);
    }

}
