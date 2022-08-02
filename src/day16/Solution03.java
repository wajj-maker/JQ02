package day16;

import java.util.HashSet;
import java.util.Set;

public class Solution03 {
    public int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    int parentI = getParent(parent, i);
                    int parentJ = getParent(parent, j);
                    if (parentI != parentJ) {
                        parent[parentI] = parentJ;
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            set.add(getParent(parent, i));
        }
        return set.size();
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
