package day04;

public class Solution01 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = nums.length - 1 - k; i <= nums.length - 1; i++) {
            res[index++] = nums[i];
        }
        for (int i = 0; i <= nums.length - 1 - k; i++) {
            res[index++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
