package day11;

public class Solution06 {

}

class NumArray {
    private int[] res;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        res = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return res[right] - res[left] + nums[right];
    }
}
