public static int[] rotateArray(int[] nums, int k) {
    int n = nums.length;
    k = k % n;

    int[] newArray = new int[n];

    for (int i = 0; i < n; i++) {
        newArray[(i + k) % n] = nums[i];
    }

    return newArray;
}