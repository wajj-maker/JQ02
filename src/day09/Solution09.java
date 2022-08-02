package day09;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution09 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.addLast(i);
            } else {  // 3  1
                while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {  // [1,3,1,2,0,5]  3
                    queue.pollLast();
                }
                queue.addLast(i);
                res[index++] = nums[queue.getFirst()];
                if (i - k + 1 == queue.getFirst()) {
                    queue.pollFirst();
                }
            }
        }
        return res;
    }
}
