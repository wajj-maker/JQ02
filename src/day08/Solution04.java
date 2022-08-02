package day08;

import java.util.HashMap;
import java.util.Map;

public class Solution04 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]) || i - map.get(nums[i]) > k) {
                map.put(nums[i], i);
            } else {
                return true;
            }
        }
        return false;
    }
}
