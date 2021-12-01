package com.java.training.entity;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

@AllArgsConstructor
@EqualsAndHashCode

@Data
public class Person implements Comparable<Person>{
    private String name;

    private int age;
    private double height;
    private String city;


    // provides the natural ordering for objects of this class

    @Override
    public int compareTo(Person that) {

        int diff = this.name.compareTo(that.name);
        if (diff == 0) {
            diff = Integer.compare(this.age, that.age);
            if(diff==0){
                diff = Double.compare(this.height, that.height);
                if(diff==0){
                    return this.city.compareTo(that.city);
                }
            }
        }
        return diff;
    }
}
