import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {
        // Clean punctuation and split by one or more whitespace characters
        // This removes commas, periods, etc., so they don't corrupt word length
        String[] words = review.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {
            // Safeguard against any trailing empty strings after split
            if (word.isEmpty()) {
                continue; 
            }

            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortWords++;
            } else if (length >= 5 && length <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords + " | Medium: " + mediumWords + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the movie review: ");
        String review = sc.nextLine();

        classifyWordLengths(review);

        sc.close();
    }
}
