package session_8.assignment_problems;

import java.util.Scanner;

public class M1_CanteenBillingCounter {

    static abstract class Customer {

        protected double amount;

        Customer(double amount) {
            this.amount = amount;
        }

        abstract double calculateFinalAmount();
    }

    static class Student extends Customer {

        Student(double amount) {
            super(amount);
        }

        @Override
        double calculateFinalAmount() {
            return amount * 0.90;
        }
    }

    static class Staff extends Customer {

        Staff(double amount) {
            super(amount);
        }

        @Override
        double calculateFinalAmount() {
            return amount * 0.95;
        }
    }

    static class Guest extends Customer {

        Guest(double amount) {
            super(amount);
        }

        @Override
        double calculateFinalAmount() {
            return amount + 10;
        }
    }

    // Factory method
    static Customer createCustomer(
            String type,
            double amount) {

        return switch (type) {
            case "STUDENT" -> new Student(amount);
            case "STAFF" -> new Staff(amount);
            default -> new Guest(amount);
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer =
                createCustomer(type, amount);

            double finalAmount =
                customer.calculateFinalAmount();

            System.out.printf(
                "%s: %.2f%n",
                type,
                finalAmount
            );

            total += finalAmount;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );
    }
}
