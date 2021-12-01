package com.java.training.programs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        // Wrong: List<String> names = new ArrayList<>("Hema", "Hima");
        // Instead, use the following
        List<String > name = Arrays.asList("Hema", "Hima", "Kavitha", "Venu");
        System.out.println(name);

        // jdk 1.5+
        for(String me:name){
            System.out.println(me);
        }

        //jdk 1.8+
        name.stream().forEach(System.out::println);

        // Printing only names starting with H
        name.stream()
                .filter(me ->me.startsWith("H"))
                .map(me->me.toUpperCase())
                .forEach(System.out::println);



    }
}
