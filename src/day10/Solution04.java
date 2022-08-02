package day10;

public class Solution04 {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp ^= nums[i];
        }
        int n = temp & (-temp);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & n) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
