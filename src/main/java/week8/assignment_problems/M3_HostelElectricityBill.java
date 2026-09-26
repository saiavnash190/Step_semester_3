package session_8.assignment_problems;

import java.util.Scanner;

public class M3_HostelElectricityBill {

    static abstract class Room {

        protected int units;

        Room(int units) {
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class SingleRoom extends Room {

        SingleRoom(int units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return units * 8;
        }
    }

    static class SharedRoom extends Room {

        private int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        double calculateBill() {
            return (units * 6.0) / occupants;
        }
    }

    static class ACRoom extends Room {

        ACRoom(int units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return units * 10 + 200;
        }
    }

    static Room createRoom(
            String type,
            int units,
            int occupants) {

        return switch (type) {
            case "SINGLE" ->
                new SingleRoom(units);

            case "SHARED" ->
                new SharedRoom(
                    units,
                    occupants
                );

            default ->
                new ACRoom(units);
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            int occupants = 0;

            if (type.equals("SHARED")) {
                occupants = sc.nextInt();
            }

            Room room =
                createRoom(
                    type,
                    units,
                    occupants
                );

            double bill =
                room.calculateBill();

            System.out.printf(
                "%s: %.2f%n",
                type,
                bill
            );

            total += bill;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );
    }
}