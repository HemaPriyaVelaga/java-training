package com.target.java.training.assignments.assignment17.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class KeyBoardUtils {
    public static int getInt(String message)
    {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }

    public static String getString(String message)
    {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();

    }

    public static Double getDouble(String message)
    {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();

    }

    public static Date getDate(String message)
    {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        try {
            Date dt = new Date();
            dt = sdf.parse(date);
            //System.out.println(dt);
            return dt;
            // or , return sdf.parse(date); without the above all statements
        } catch (ParseException e) {
            return null;
        }
    }
}
