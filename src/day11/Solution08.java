package day11;

public class Solution08 {

}

//class NumArray {
//    private int[] help;
//    private int[] nums;
//    public NumArray(int[] nums) {
//        this.nums = nums;
//        help = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0) {
//                help[i] = nums[0];
//            } else {
//                help[i] = help[i - 1] + nums[i];
//            }
//        }
//    }
//    public void update(int index, int val) {
//        int num = nums[index];
//        nums[index] = val;
//        if (val != num) {
//            int value = val - num;
//            for (int i = index; i < nums.length; i++) {
//                help[i] += value;
//            }
//        }
//    }
//    public int sumRange(int left, int right) {
//        return help[right] - help[left] + nums[left];
//    }
//}


