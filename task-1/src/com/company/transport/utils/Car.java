package com.company.transport.utils;

public class Car {
    public String type;
    public String reg_number;
    public String extra;
    public double mileage;
    public double fuel;
    public double consumption;

    public Car(String reg_number, double mileage, String extra) {
        this.extra = extra;
        this.reg_number = reg_number;
        this.mileage = mileage;
    }

    public double fullPrice(){ return (mileage /100) * fuel * consumption;}
}
