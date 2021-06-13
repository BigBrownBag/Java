package com.company.transport.utils;

public class Car_normal extends Car {
    public Car_normal(String reg_number, double mileage, String extra) {
        super(reg_number, mileage, extra);
        this.fuel = 46.10;
        this.consumption = 12.5;
        this.type = "легковой";
    }
}
