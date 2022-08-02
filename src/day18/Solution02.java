package day18;

public class Solution02 {
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        while (left < right) {
            int cnt = 1;
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum = sum + nums[i];
            }
            if (cnt > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
