package com.company.transport.utils;

public class Car_cargo extends Car {
    public Car_cargo(String reg_number, double mileage, String extra) {
        super(reg_number, mileage, extra);
        this.fuel = 48.90;
        this.consumption = 12.0;
        this.type = "грузовой";
    }
}
