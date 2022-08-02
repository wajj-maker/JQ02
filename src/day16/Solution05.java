package day16;

import java.util.HashSet;
import java.util.Set;

public class Solution05 {
    private int res = 0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] check = new boolean[grid.length][grid[0].length];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !check[i][j]) {
                    check[i][j] = true;
                    set.removeAll(set);
                    set.add(grid[0].length * i + j);
                    dfs(check, grid, i, j, set);
                    if (set.size() > res) {
                        res = set.size();
                    }
                }
            }
        }
        return res;
    }

    public void dfs(boolean[][] check, int[][] grid, int y, int x, Set<Integer> set) {
        if (y - 1 >= 0 && !check[y - 1][x] && grid[y - 1][x] == 1) {
            check[y - 1][x] = true;
            set.add((y - 1) * grid[0].length + x);
            dfs(check, grid, y - 1, x, set);
        }
        if (x - 1 >= 0 && !check[y][x - 1] && grid[y][x - 1] == 1) {
            check[y][x - 1] = true;
            set.add(y * grid[0].length + x - 1);
            dfs(check, grid, y, x - 1, set);
        }
        if (y + 1 < grid.length && !check[y + 1][x] && grid[y + 1][x] == 1) {
            check[y + 1][x] = true;
            set.add((y + 1) * grid[0].length + x);
            dfs(check, grid, y + 1, x, set);
        }
        if (x + 1 < grid[0].length && !check[y][x + 1] && grid[y][x + 1] == 1) {
            check[y][x + 1] = true;
            set.add(y * grid[0].length + x + 1);
            dfs(check, grid, y, x + 1, set);
        }
    }
}
