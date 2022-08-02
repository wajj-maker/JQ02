package day15;

import java.util.*;

public class Solution10 {

}

class Solution {
    private int[] nums;
    private int[] arr;
    private List<Integer> list = new ArrayList<>();
    private Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
    }
    public int[] reset() {
        return nums;
    }
    public int[] shuffle() {
        list.removeAll(list);
        for (int i = 0; i < nums.length; i++) {
            list.add(i);
        }
        int index = 0;
        arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int p = random.nextInt(list.size());
            arr[index++] = nums[list.get(p)];
            list.remove(p);
        }
        return arr;
    }
}
