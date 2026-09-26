package session_8.assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

public class M5_StreamingPlanRenewalReminder {

    static abstract class Plan {

        protected String name;
        protected LocalDate startDate;

        Plan(
                String name,
                LocalDate startDate) {

            this.name = name;
            this.startDate = startDate;
        }

        abstract int getValidityDays();

        LocalDate getRenewalDate() {

            return startDate.plusDays(
                getValidityDays()
            );
        }
    }

    static class BasicPlan extends Plan {

        BasicPlan(
                String name,
                LocalDate startDate) {

            super(name, startDate);
        }

        @Override
        int getValidityDays() {
            return 30;
        }
    }

    static class StandardPlan extends Plan {

        StandardPlan(
                String name,
                LocalDate startDate) {

            super(name, startDate);
        }

        @Override
        int getValidityDays() {
            return 90;
        }
    }

    static class PremiumPlan extends Plan {

        PremiumPlan(
                String name,
                LocalDate startDate) {

            super(name, startDate);
        }

        @Override
        int getValidityDays() {
            return 365;
        }
    }

    static Plan createPlan(
            String type,
            String name,
            LocalDate startDate) {

        return switch (type) {

            case "BASIC" ->
                new BasicPlan(
                    name,
                    startDate
                );

            case "STANDARD" ->
                new StandardPlan(
                    name,
                    startDate
                );

            default ->
                new PremiumPlan(
                    name,
                    startDate
                );
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            LocalDate startDate =
                LocalDate.parse(sc.next());

            Plan plan =
                createPlan(
                    type,
                    name,
                    startDate
                );

            System.out.println(
                plan.name + ": " +
                plan.getRenewalDate()
            );
        }
    }
}
