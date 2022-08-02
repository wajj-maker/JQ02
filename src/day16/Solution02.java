package day16;

import java.util.HashMap;
import java.util.Map;

public class Solution02 {
    public long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0] > edges[i][1] ? edges[i][0] : edges[i][1];
            int y = edges[i][0] < edges[i][1] ? edges[i][0] : edges[i][1];
            int parentX = getParent(parent, x);
            int parentY = getParent(parent, y);
            if (parentX != parentY) {
                parent[parentX] = parentY;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(getParent(parent, i), map.getOrDefault(getParent(parent, i), 0) + 1);
        }
        long res = 0;
        if (map.size() == 1) return 0;
        long[] arr = new long[map.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  // [[1,0],[3,1],[0,4],[2,1]]
            arr[index++] = entry.getValue();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                res += arr[i] * arr[j];
            }
        }
        return res;
    }

    public int getParent(int[] parent, int x) {
        if (x == parent[x]) {
            return x;
        } else {
            parent[x] = getParent(parent, parent[x]);
            return parent[x];
        }
    }
}
