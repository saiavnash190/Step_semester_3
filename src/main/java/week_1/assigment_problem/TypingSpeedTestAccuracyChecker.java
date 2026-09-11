package src.main.java.week_1.assigment_problem;
import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;

        // Loop up to the shorter string's length to prevent crashes
        int minLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < minLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // If they didn't finish or typed extra, the first mismatch is where the length diverged
        if (firstMismatch == -1 && original.length() != typed.length()) {
            firstMismatch = minLength;
        }

        // Total characters to evaluate accuracy against (the target original string length)
        double accuracy = (matched * 100.0) / original.length();

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%\n", matched, original.length(), accuracy);

        if (firstMismatch == -1) {
            System.out.println("Result: Perfect match!");
        } else {
            System.out.print("First Mismatch at position " + (firstMismatch + 1) + ": ");
            if (firstMismatch >= original.length()) {
                System.out.println("User typed extra characters beyond the original text.");
            } else if (firstMismatch >= typed.length()) {
                System.out.println("User stopped typing early. Expected '" + original.charAt(firstMismatch) + "'");
            } else {
                System.out.println("Expected '" + original.charAt(firstMismatch) + "' vs Typed '" + typed.charAt(firstMismatch) + "'");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the original string: ");
        String original = sc.nextLine();

        System.out.print("Enter the typed string: ");
        String typed = sc.nextLine();

        // Removed the hard restriction so the program can actually handle mistyped lengths
        checkTypingAccuracy(original, typed);

        sc.close();
    }
}
