public class ClassifyMatches {
    private static double rowAverage(int[] row) {
        int sum = 0;

        for (int value : row) {
            sum += value;
        }

        return (double) sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        String result = "";

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);

            if (average >= threshold) {
                result += "Match " + i + ": Power Surge";
            } else {
                result += "Match " + i + ": Normal";
            }

            if (i < runsPerOver.length - 1) {
                result += " | ";
            }
        }

        return result;
    }
}