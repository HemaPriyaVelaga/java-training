package com.target.training.java.programs;

import java.util.Scanner;

public class KeyBoardUtil {
    public static String getString(String msg){
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int getInt(int data){
        System.out.println(data);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
