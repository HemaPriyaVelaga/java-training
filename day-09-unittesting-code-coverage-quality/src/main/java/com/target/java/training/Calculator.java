package com.target.java.training;

public class Calculator {

    public Double add(Object...nums)
    {
        //... indicates that we can supply any
        // number of Double numbers
        // Here, nums behaves exactly as an array
        // We can find the length and such things as in the case of an array
        Double sum = 0.;
        for (Object n:nums)
        {
            if(n!=null)
                sum+=Double.valueOf(n.toString());
        }

        return sum;

    }
}
