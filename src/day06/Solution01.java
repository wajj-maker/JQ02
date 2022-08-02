package day06;

public class Solution01 {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int temp = 0;
        for (int r = 0; r < nums.length; r++) {
            temp += nums[r];
            while (temp >= target) {
                if (r - left + 1< minLength) {
                    minLength = r - left + 1;
                }
                temp -= nums[left];
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }
}
