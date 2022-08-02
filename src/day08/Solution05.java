package day08;

import java.util.TreeSet;

public class Solution05 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long cell = set.ceiling((long)nums[i]);
            Long floor = set.floor((long)nums[i]);
            if (cell != null && Math.abs(cell - nums[i]) <= t || floor != null && Math.abs(floor - nums[i]) <= t) {
                return true;
            }
            set.add((long)nums[i]);
            if (set.size() == k + 1) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
