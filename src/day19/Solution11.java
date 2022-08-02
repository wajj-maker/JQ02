package day19;

public class Solution11 {
    public int islandPerimeter(int[][] grid) {
//        boolean[][] check = new boolean[grid.length][grid[0].length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 < 0) {
                        num++;
                    }
                    if (i + 1 >= grid.length) {
                        num++;
                    }
                    if (j - 1 < 0) {
                        num++;
                    }
                    if (j + 1 >= grid[0].length) {
                        num++;
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                        num++;
                    }
                    if (i + 1 < grid.length  && grid[i + 1][j] == 0) {
                        num++;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                        num++;
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 0) {
                        num++;
                    }
                }
            }
        }
        return num;
    }
}
