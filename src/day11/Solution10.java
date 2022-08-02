package day11;

import java.util.HashSet;
import java.util.Set;

public class Solution10 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set.add(nums2[i]);
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (Integer integer : set) {
            res[index++] = integer;
        }
        return res;
    }
}
