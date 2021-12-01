package com.target.training.programs;

import java.util.ResourceBundle;
import java.util.Set;

public class ResourceBundleDemo {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("hema");
        System.out.println(rb);

        Set<String> keys = rb.keySet();

        for (String key: keys)
        {
            System.out.printf("%s --> %s \n", key,rb.getString(key));
        }
    }
}
