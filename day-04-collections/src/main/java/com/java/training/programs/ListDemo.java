package com.java.training.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListDemo {
    static void printListDetail(List< ? extends Object> data){
        System.out.println("data.size() = " + data.size());
        System.out.println("Content: " + data.toString());
        System.out.println();
    }
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        //List<Integer> nums = new Vector<>();
        //List<Integer> nums = new LinkedList<>();
        // Even the above commented codes produce the same outputs
        // This is becaus they all use the common list interface of java


        printListDetail(nums);
        nums.add(12);
        nums.add(23);
        nums.add(234);

        printListDetail(nums);
        nums.add(0, 23);
        nums.add(2, 100);
        printListDetail(nums);

        int index = nums.indexOf(23);
        nums.set(index, 33);
        printListDetail(nums);


        Vector<Integer> v = new Vector<>();
        System.out.println("v.capacity() = " + v.capacity());
        for(int i=0;i<10;i++)
        {
            v.add(i);
        }
        v.add(100);
        System.out.println("v.capacity() = " + v.capacity());

    }
}
