import java.util.HashSet;
import java.util.Scanner;

public class ExamHallSeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        HashSet<Integer> seenSeats = new HashSet<>();
        HashSet<Integer> printedDuplicates = new HashSet<>();
        boolean duplicateFound = false;

        for (int seat : seatNumbers) {
            // If we have seen it before, it's a duplicate
            if (seenSeats.contains(seat)) {
                // Ensure we only print it the first time we realize it's a duplicate
                if (!printedDuplicates.contains(seat)) {
                    System.out.println("Duplicate Seat Number Found: " + seat);
                    printedDuplicates.add(seat);
                    duplicateFound = true;
                }
            } else {
                seenSeats.add(seat);
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of seat assignments: ");
        int n = sc.nextInt();
        
        int[] seatNumbers = new int[n];
        System.out.println("Enter the seat numbers:");
        for (int i = 0; i < n; i++) {
            seatNumbers[i] = sc.nextInt();
        }
        
        checkDuplicateSeats(seatNumbers);
        sc.close();
    }
}
