public static int[] findTopThreeScores(int[] scores) {
    int first = Integer.MIN_VALUE;
    int second = Integer.MIN_VALUE;
    int third = Integer.MIN_VALUE;

    for (int score : scores) {
        if (score >= first) {
            third = second;
            second = first;
            first = score;
        } else if (score >= second) {
            third = second;
            second = score;
        } else if (score > third) {
            third = score;
        }
    }

    return new int[]{first, second, third};
}