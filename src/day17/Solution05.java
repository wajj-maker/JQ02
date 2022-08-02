package day17;

import java.util.*;

public class Solution05 {
    private Map<Integer, List<Integer>> map;
    private Random random;
    public Solution05(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                List<Integer> list = new ArrayList<>();
                map.put(nums[i], list);
            }
            map.get(nums[i]).add(i);
        }
    }
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
