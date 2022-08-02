package day13;

import java.util.LinkedList;
import java.util.Queue;

public class Solution01 {
    public int longestIncreasingPath(int[][] matrix) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] check = new boolean[matrix.length][matrix[0].length];
        int res = 0;
        int[][] check2 = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!check[i][j]) {
                    queue.offer(matrix[i][j]);
                    queue.offer(i);
                    queue.offer(j);
                    check[i][j] = true;
                    int num = 0;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        num++;
                        while (size > 0) {
                            size -= 3;
                            int value = queue.poll();
                            int y = queue.poll();
                            int x = queue.poll();
                            if (y - 1 >= 0 && matrix[y - 1][x] > value && check2[y - 1][x] < num) {
                                queue.offer(matrix[y - 1][x]);
                                queue.offer(y - 1);
                                queue.offer(x);
                                check2[y - 1][x] = num;
                                check[y - 1][x] = true;
                            }
                            if (x - 1 >= 0 && matrix[y][x - 1] > value && check2[y][x - 1] < num) {
                                queue.offer(matrix[y][x - 1]);
                                queue.offer(y);
                                queue.offer(x - 1);
                                check2[y][x - 1] = num;
                                check[y][x - 1] = true;
                            }
                            if (x + 1 < matrix[0].length && matrix[y][x + 1] > value && check2[y][x + 1] < num) {
                                queue.offer(matrix[y][x + 1]);
                                queue.offer(y);
                                queue.offer(x + 1);
                                check2[y][x + 1] = num;
                                check[y][x + 1] = true;
                            }
                            if (y + 1 < matrix.length && matrix[y + 1][x] > value && check2[y + 1][x] < num) {
                                queue.offer(matrix[y + 1][x]);
                                queue.offer(y + 1);
                                queue.offer(x);
                                check2[y + 1][x] = num;
                                check[y + 1][x] = true;
                            }
                        }
                    }
                    if (num > res) {
                        res = num;
                    }
                }
            }
        }
        return res;
    }
}
