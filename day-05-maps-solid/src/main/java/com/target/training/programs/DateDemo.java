package com.target.training.programs;

import com.target.training.utils.KeyboardUtil;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        String dob = KeyboardUtil.getString("Enter dob (dd/MM/yyyy): ");
        Date dt = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            sdf.setLenient(false); // to not accept invalid date and month
            dt = sdf.parse(dob);
            System.out.println(dt);
        } catch (ParseException e) {
            System.out.println("Invalid date format!");
        }


        // or go to keyboard util

        KeyboardUtil.getDate("Please enter your DOB in dd/MM/yyyy format: ");

    }
}
