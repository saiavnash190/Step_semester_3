package session_8.assignment_problems;

import java.util.Scanner;

public class M2_CampusParkingChargeCalculator {

    static abstract class Vehicle {

        protected int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract double calculateCharge();
    }

    static class Bike extends Vehicle {

        Bike(int hours) {
            super(hours);
        }

        @Override
        double calculateCharge() {
            return hours * 10;
        }
    }

    static class Car extends Vehicle {

        Car(int hours) {
            super(hours);
        }

        @Override
        double calculateCharge() {

            if (hours == 1) {
                return 30;
            }

            return 30 + (hours - 1) * 20;
        }
    }

    static class Truck extends Vehicle {

        Truck(int hours) {
            super(hours);
        }

        @Override
        double calculateCharge() {

            return Math.max(
                100,
                hours * 50
            );
        }
    }

    static Vehicle createVehicle(
            String type,
            int hours) {

        return switch (type) {
            case "BIKE" -> new Bike(hours);
            case "CAR" -> new Car(hours);
            default -> new Truck(hours);
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle =
                createVehicle(type, hours);

            double charge =
                vehicle.calculateCharge();

            System.out.printf(
                "%s: %.2f%n",
                type,
                charge
            );

            total += charge;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );
    }
}