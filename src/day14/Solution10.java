package day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution10 {
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1));
//        for (int i = 0; i < nums1.length && i < k; i++) {
//            for (int j = 0; j < nums2.length && j < k; j++) {
//                priorityQueue.offer(Arrays.asList(nums1[i], nums2[j]));
//            }
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        while (!priorityQueue.isEmpty()) {
//            res.add(priorityQueue.poll());
//            if (res.size() == k) break;
//        }
//        return res;
//    }

//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> ans = new ArrayList<>();
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
//        for (int i = 0; i < Math.min(nums1.length, k); i++) {
//            pq.add(new int[]{i, 0});
//        }
//        while (k > 0 && !pq.isEmpty()) {
//            int[] idx = pq.poll();
//            ans.add(List.of(nums1[idx[0]], nums2[idx[1]]));
//            if (idx[1] + 1 < nums2.length) {
//                pq.add(new int[]{idx[0], idx[1] + 1});
//            }
//            k--;
//        }
//        return ans;
//    }
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//
//    }

//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> ans = new ArrayList<>();
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
//        for (int i = 0; i < Math.min(nums1.length, k); i++) {
//            pq.add(new int[]{i, 0});
//        }
//        while (k > 0 && !pq.isEmpty()) {
//            int[] idx = pq.poll();
//            ans.add(List.of(nums1[idx[0]], nums2[idx[1]]));
//            if (idx[1] + 1 < nums2.length) {
//                pq.add(new int[]{idx[0], idx[1] + 1});
//            }
//            k--;
//        }
//        return ans;
//    }
}
