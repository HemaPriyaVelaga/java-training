package com.target.java.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class triangle implements shape{

    private double base;
    private double height;



    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getName() {
        return "Triangle";
    }
}
