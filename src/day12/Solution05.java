package day12;

import java.util.*;

public class Solution05 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges1) {
        if (n == 1) {
            List<Integer> t = new ArrayList<>();
            t.add(0);
            return t;
        }
        List<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < edges1.length; i++) {
            int num1 = edges1[i][0];
            int num2 = edges1[i][1];
            if (edges[num1] == null) {
                edges[num1] = new ArrayList<>();
            }
            if (edges[num2] == null) {
                edges[num2] = new ArrayList<>();
            }
            edges[num1].add(num2);
            edges[num2].add(num1);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.removeAll(queue);
            queue.offer(i);
            set.removeAll(set);
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                step++;
                while (size > 0) {
                    size--;
                    int x = queue.poll();
                    set.add(x);
                    for (int j = 0; j < edges[x].size(); j++) {
                        if (!set.contains(edges[x].get(j))) {
                            set.add(edges[x].get(j));
                            queue.offer(edges[x].get(j));
                        }
                    }
                }
                if (set.size() == n) break;
            }
            if (step <= min) {
                if (step == min) {
                    res.add(i);
                } else {
                    min = step;
                    res.removeAll(res);
                    res.add(i);
                }
            }
        }
        return res;
    }
}
