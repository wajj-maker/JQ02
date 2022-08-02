package day16;

public class Solution04 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i < edges.length + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int parentX = getParent(parent, x);
            int parentY = getParent(parent, y);
            if (parentX != parentY) {
                parent[parentX] = parentY;
            } else {
                return new int[]{x, y};
            }
        }
        return new int[]{-1, -1};
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
