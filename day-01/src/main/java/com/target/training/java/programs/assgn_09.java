package com.target.training.java.programs;

public class assgn_09 {

    public static int[] sumOfEvensAndOdds(int []nums) {
        // do stuff here
        int [] result = {0,0};

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0){
                result[0]+=nums[i];
            }
            else{
                result[1]+=nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int [] result = sumOfEvensAndOdds(nums);
        System.out.println("Sum of even numbers is " + result[0] + " and sum of odd numbers is "+result[1]);
    }
}
