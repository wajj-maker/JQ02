package day18;

import java.util.ArrayList;
import java.util.List;

public class Solution09 {
    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % nums.length] += nums.length;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 2 * nums.length) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
