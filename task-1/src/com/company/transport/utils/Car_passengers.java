package com.company.transport.utils;

public class Car_passengers extends Car  {
    public Car_passengers(String reg_number, double mileage, String extra) {
        super(reg_number, mileage, extra);
        this.fuel = 47.50;
        this.consumption = 11.5;
        this.type = "пассажирский";
    }
}
