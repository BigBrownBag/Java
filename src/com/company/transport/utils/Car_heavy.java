package com.company.transport.utils;

public class Car_heavy extends Car  {
    public Car_heavy(String reg_number, double mileage, String extra) {
        super(reg_number, mileage, extra);
        this.fuel = 48.90;
        this.consumption = 20.0;
        this.type = "тяжелая техника(краны)";
    }
}
