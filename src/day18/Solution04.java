package day18;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution04 {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int max = -1001;
        for (Integer integer : set) {
            if (integer > max) {
                max = integer;
            }
            if (priorityQueue.size() < 3 ) {
                priorityQueue.offer(integer);
            } else if (priorityQueue.peek() < integer) {
                priorityQueue.poll();
                priorityQueue.offer(integer);
            }
        }
        if (priorityQueue.size() < 3) {
            return max;
        }
        return priorityQueue.peek();
    }
}
