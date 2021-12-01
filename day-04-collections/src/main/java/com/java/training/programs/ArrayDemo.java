package com.java.training.programs;

public class ArrayDemo {

    // Similar to array.toString() inbuilt function
    static String toString(int[] arr){
        String t = "[";
        for (int i=0;i< arr.length-1;i++){
            t+=arr[i] + ", ";
        }
        t+=arr[arr.length-1]+"]";
        return t;
    }

    // Function to grow array
    public static int[] push(int[] arr, int num){
        int[] newarr = new int[arr.length +1];

        for(int i=0;i< newarr.length-1; i++)
        {
            newarr[i] = arr[i];
        }
        newarr[newarr.length-1] = num;


        // Better way
        //System.arraycopy(arr, 0 , newarr, 0, arr.length);
        //newarr[newarr.length-1] = num;

        return  newarr;
    }



    public static void main(String[] args) {

        //int[] nums;
        //int[] nums = {1,2,3};
        int [] nums;
        //nums = new int[10]; // memory is reserved for 10 integers
        nums = new int[]{10, 20, 30};
        System.out.println(nums); //Uninitialised arrays give error

        System.out.printf("Nums is: " + toString(nums) + "\n");
        nums = push(nums, 40);
        System.out.printf("Nums is: " + toString(nums) + "\n");
    }
}
