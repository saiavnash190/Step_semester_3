import java.util.Arrays;
import java.util.ArrayList;
public static int[][] threeSum(int[] nums) {
    Arrays.sort(nums);
    ArrayList<int[]> result = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }

        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];

            if (sum == 0) {
                result.add(new int[]{nums[i], nums[left], nums[right]});

                int leftValue = nums[left];
                int rightValue = nums[right];

                while (left < right && nums[left] == leftValue) {
                    left++;
                }

                while (left < right && nums[right] == rightValue) {
                    right--;
                }
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    return result.toArray(new int[result.size()][]);
}