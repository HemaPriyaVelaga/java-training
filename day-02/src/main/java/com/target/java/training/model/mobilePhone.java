package com.target.java.training.model;

public class mobilePhone extends product {

    private String dimension;
    private String batteryCapacity;

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return ("mobilePhone{" +
                "dimension='" + dimension + '\'' +
                ", batteryCapacity='" + batteryCapacity + '\'' +
                ", Product details='" + super.toString()+
                '}');
    }
}
