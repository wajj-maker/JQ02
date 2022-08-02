package day14;

import java.util.*;

public class Solution07 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[index]);
        int num = index;
        for (int i = index - 1; i >= 0; i--) {
            if (list.get(list.size() - 1) % nums[i] == 0 && dp[i] + 1 == dp[num]) {
                list.add(nums[i]);
                num = i;
            }
        }
        Collections.reverse(list);
        return list;
    }
}
