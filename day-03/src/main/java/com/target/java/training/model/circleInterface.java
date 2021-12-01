package com.target.java.training.model;

import lombok.*;

@Getter
@Setter
@ToString
@Data
// Thought lombak imports default getter and setters,
// We can still add our own setters
// If we give our own setter/getter prior to importing lombok
// lombok ignores the available ones and creates only the ones that dont exist

@AllArgsConstructor
@NoArgsConstructor
public class circleInterface implements  shape{

    private double radius;

    @Override
    public double getArea() {
        return PI * radius * radius;

        // PI is obtained from circle interface
    }

    @Override
    public String getName() {
        return "Circle";
    }

}


// Either reimplements methods from the shape interface
// Or mark this also abstract
// But if we mark it as abstract, we cant invoke its object