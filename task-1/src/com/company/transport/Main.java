package com.company.transport;

import com.company.transport.utils.*;

import java.util.*;

public class Main {
    public static Car parse(String inputValue){
        inputValue = inputValue.replace("_", "-");
        String[] transport_attrs = inputValue.split("-");
        String code = transport_attrs[0];
        String reg_number = transport_attrs[1];
        double mileage = Double.parseDouble(transport_attrs[2]);
        String extra = "";
        if (transport_attrs.length == 4) {
            extra = transport_attrs[3];
        }

        return switch (code) {
            case "C100" -> new Car_normal(reg_number, mileage, extra);
            case "C200" -> new Car_cargo(reg_number, mileage, extra);
            case "C300" -> new Car_passengers(reg_number, mileage, extra);
            case "C400" -> new Car_heavy(reg_number, mileage, extra);
            default -> new Car("N/A", 0., "");
        };
    }

    public static void main(String[] args) {
	    String[] inputArr = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50",
                "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29",
                "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};

        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Car> normalCars = new ArrayList<>();
        ArrayList<Car> cargoCars = new ArrayList<>();
        ArrayList<Car> passengersCars = new ArrayList<>();
        ArrayList<Car> heavyCars = new ArrayList<>();
        double fullCost = 0;
        double costNormal = 0;
        double costCargo = 0;
        double costPassengers = 0;
        double costHeavy = 0;
	    for (String inputValue : inputArr) {
            Car car = parse(inputValue);
            cars.add(car);
        }
	    for (Car car : cars) {
	        fullCost += car.fullPrice();
	        if (car.type=="легковой"){costNormal+=car.fullPrice();normalCars.add(car);}
	        else if (car.type=="грузовой"){costCargo+=car.fullPrice();cargoCars.add(car);}
	        else if (car.type=="пассажирский"){costPassengers+=car.fullPrice();passengersCars.add(car);}
            else if (car.type=="тяжелая техника(краны)"){costHeavy+=car.fullPrice();heavyCars.add(car);}
        }
	    System.out.println("Общая стоимость расходов на ГСМ:");
	    System.out.println(String.format("Полная стоимость расходов - %.0f", fullCost));
        System.out.println("Расходы на легковые автомобили - " + costNormal);
        System.out.println("Расходы на грузовые автомобили - " + costCargo);
        System.out.println("Расходы на пассажирские автомобили - " + costPassengers);
        System.out.println("Расходы на технику - " + costHeavy);

        double a = maximum(maximum(costNormal,costCargo),maximum(costHeavy,costPassengers));
        if (a==costNormal){System.out.println("Тип авто имеющий наибольшую стоимость расходов - легковые");}
        else if (a==costCargo){System.out.println("Тип авто имеющий наибольшую стоимость расходов - грузовые");}
        else if (a==costPassengers){System.out.println("Тип авто имеющий наибольшую стоимость расходов - пассажирские");}
        else if (a==costHeavy){System.out.println("Тип авто имеющий наибольшую стоимость расходов - тяжелая техника(краны)");}

        double b = minimum(minimum(costNormal,costCargo),minimum(costHeavy,costPassengers));
        if (b==costNormal){System.out.println("Тип авто имеющий наименьшую стоимость расходов - легковые");}
        else if (b==costCargo){System.out.println("Тип авто имеющий наименьшую стоимость расходов - грузовые");}
        else if (b==costPassengers){System.out.println("Тип авто имеющий наименьшую стоимость расходов - пассажирские");}
        else if (b==costHeavy){System.out.println("Тип авто имеющий наименьшую стоимость расходов - тяжелая техника(краны)");}

        System.out.println("Информация о каждом автомобиле: (Сортировка по пробегу)");
        System.out.println("Легковые");
        sortByMileage(normalCars);
        for (Car car : normalCars) {
            System.out.println(String.format("Автомобиль типа %s\tномер %s\t пробег %.0f\t доп. параметр %s", car.type, car.reg_number, car.mileage, car.extra));
        }
        System.out.println("Грузовые");
        sortByMileage(cargoCars);
        for (Car car : cargoCars) {
            System.out.println(String.format("Автомобиль типа %s\tномер %s\t пробег %.0f\t доп. параметр %s", car.type, car.reg_number, car.mileage, car.extra));
        }
        System.out.println("Пассажирские");
        sortByMileage(passengersCars);
        for (Car car : passengersCars) {
            System.out.println(String.format("Автомобиль типа %s\tномер %s\t пробег %.0f\t доп. параметр %s", car.type, car.reg_number, car.mileage, car.extra));
        }
        System.out.println("Тяжелая техника(краны)");
        sortByMileage(heavyCars);
        for (Car car : heavyCars) {
            System.out.println(String.format("Автомобиль типа %s\tномер %s\t пробег %.0f\t доп. параметр %s", car.type, car.reg_number, car.mileage, car.extra));
        }

        System.out.println("Информация о каждом автомобиле: (Сортировка по доп. параметру)");
        System.out.println("Легковые");
        for (Car car : normalCars) {
            System.out.println(String.format("Автомобиль типа %s\tномер %s\t пробег %.0f\t доп. параметр %s", car.type, car.reg_number, car.mileage, car.extra));
        }
        System.out.println("Грузовые");
        sortByExtra(cargoCars);
        for (Car car : cargoCars) {
            System.out.println(String.format("Автомобиль типа %s\tномер %s\t пробег %.0f\t доп. параметр %s", car.type, car.reg_number, car.mileage, car.extra));
        }
        System.out.println("Пассажирские");
        sortByExtra(passengersCars);
        for (Car car : passengersCars) {
            System.out.println(String.format("Автомобиль типа %s\tномер %s\t пробег %.0f\t доп. параметр %s", car.type, car.reg_number, car.mileage, car.extra));
        }
        System.out.println("Тяжелая техника(краны)");
        sortByExtra(heavyCars);
        for (Car car : heavyCars) {
            System.out.println(String.format("Автомобиль типа %s\tномер %s\t пробег %.0f\t доп. параметр %s", car.type, car.reg_number, car.mileage, car.extra));
        }

    }

    public static ArrayList<Car> sortByExtra(ArrayList<Car> cars) {// слишком долго тупил с Comparable
        for (int i = cars.size()-1; i > 0; i--) {
            for (int j = 0 ; j < i ; j++) {
                if (Double.parseDouble(cars.get(j).extra) > Double.parseDouble(cars.get(j+1).extra)) {
                    Car tmp = cars.get(j);
                    cars.set(j, cars.get(j+1));
                    cars.set(j+1, tmp);
                }
            }
        }
        return cars;
    }

    public static ArrayList<Car> sortByMileage(ArrayList<Car> cars) {
        for (int i = cars.size()-1; i > 0; i--) {
            for (int j = 0 ; j < i ; j++) {
                if (cars.get(j).mileage > cars.get(j+1).mileage) {
                    Car tmp = cars.get(j);
                    cars.set(j, cars.get(j+1));
                    cars.set(j+1, tmp);
                }
            }
        }
        return cars;
    }

    public static double minimum(double a, double b){
        if (a>b) {
            return b;
        } else {return a;}
    }

    public static double maximum(double a, double b){
        if (a>b) {
            return a;
        } else {return b;}
    }
}
