package day19;

import java.util.ArrayList;
import java.util.List;

public class Solution01 {
    private boolean flagX;
    private boolean flagY;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] check = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                flagY = false;
                flagX = false;
                check[i][j] = true;
                dfs(check, heights, i, j);
                check[i][j] = false;
                if (flagX && flagY) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public void dfs(boolean[][] check, int[][] heights, int y, int x) {
        if (y == 0 || x == 0) {
            flagY = true;
        }
        if (y == heights.length - 1 || x == heights[0].length - 1) {
            flagX = true;
        }
        if (flagX && flagY) {
            return;
        }
        if (y - 1 >= 0 && !check[y - 1][x] && heights[y][x] >= heights[y - 1][x]) {
            check[y - 1][x] = true;
            dfs(check, heights, y - 1, x);
            check[y - 1][x] = false;
        }
        if (flagX && flagY) {
            return;
        }
        if (x - 1 >= 0 && !check[y][x - 1] && heights[y][x - 1] <= heights[y][x]) {
            check[y][x - 1] = true;
            dfs(check, heights, y, x - 1);
            check[y][x - 1] = false;
        }
        if (flagX && flagY) {
            return;
        }
        if (x + 1 < heights[0].length && !check[y][x + 1] && heights[y][x] >= heights[y][x + 1]) {
            check[y][x + 1] = true;
            dfs(check, heights, y, x + 1);
            check[y][x + 1] = false;
        }
        if (flagX && flagY) {
            return;
        }
        if (y + 1 < heights.length && !check[y + 1][x] && heights[y][x] >= heights[y + 1][x]) {
            check[y + 1][x] = true;
            dfs(check, heights, y + 1, x);
            check[y + 1][x] = false;
        }
    }
}
