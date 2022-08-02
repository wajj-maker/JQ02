package day12;

import java.util.Arrays;

public class Solution11 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] arr = Arrays.copyOf(nums, nums.length);
        int right = nums.length - 1;
        int left = right / 2;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? arr[left--] : arr[right--];
        }
    }
}
