package day09;

import java.util.ArrayList;
import java.util.List;

public class Solution04 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        int left = nums[0];
        for (int i = 0; i < nums.length; i++) { // [0,1,2,4,5,7]
            if ((i + 1 == nums.length) || (nums[i] + 1 != nums[i + 1])) {
                if (nums[i] == left) {
                    list.add(left + "");
                } else {
                    String str = left + "->" + nums[i];
                    list.add(str);
                }
                if (i + 1 != nums.length) {
                    left = nums[i + 1];
                }
            }
        }
        return list;
    }
}
