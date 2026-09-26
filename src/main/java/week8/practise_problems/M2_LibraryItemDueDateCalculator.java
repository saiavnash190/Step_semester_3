package session_8.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

public class M2_LibraryItemDueDateCalculator {

    static abstract class LibraryItem {

        protected String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getBorrowingDays();

        LocalDate getDueDate() {

            LocalDate currentDate =
                LocalDate.of(2023, 10, 26);

            return currentDate.plusDays(
                getBorrowingDays()
            );
        }
    }

    static class Book extends LibraryItem {

        Book(String title) {
            super(title);
        }

        @Override
        int getBorrowingDays() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {

        DVD(String title) {
            super(title);
        }

        @Override
        int getBorrowingDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {

        Magazine(String title) {
            super(title);
        }

        @Override
        int getBorrowingDays() {
            return 3;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String type =
                line.substring(0, line.indexOf(" "));

            String title =
                line.substring(line.indexOf(" ") + 1)
                    .replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            }
            else if (type.equals("DVD")) {
                item = new DVD(title);
            }
            else {
                item = new Magazine(title);
            }

            System.out.println(
                item.title + ": " +
                item.getDueDate()
            );
        }
    }
}