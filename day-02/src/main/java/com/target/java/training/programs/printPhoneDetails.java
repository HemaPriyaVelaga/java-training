package com.target.java.training.programs;

import com.target.java.training.model.mobilePhone;

public class printPhoneDetails {
    public static void main(String[] args) {
        mobilePhone p1 = new mobilePhone();
        p1.setBatteryCapacity("5000 mAh");
        p1.setDimension("6.4 inch");

        System.out.println(p1);
    }
}
