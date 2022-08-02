package day17;

public class Solution03 {
    public int maxRotateFunction(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int sum = 0;
        int mu = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            mu += nums[i] * i;
        }
        int max = mu;
        int temp = mu;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp =  temp + sum - nums[i] * nums.length;
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }
}
