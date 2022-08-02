package day09;

import java.util.*;

public class Solution05 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (!set.contains(nums[i]) && map.get(nums[i]) > nums.length / 3) {
                list.add(nums[i]);
                set.add(nums[i]);
            }
        }
        return list;
    }
}
