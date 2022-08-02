package day14;

public class Solution04 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] helper = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                helper[i + 1][j + 1] = helper[i][j + 1] + helper[i + 1][j] - helper[i][j] + matrix[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length + 1; i++) {
            for (int j = 0; j < matrix[0].length + 1; j++) {
                for (int p = i; p < matrix.length; p++) {
                    for (int q = j; q < matrix[0].length; q++) {
                        int num = helper[p + 1][q + 1] - helper[i][q + 1] - helper[p + 1][j] + helper[i][j];
                        if (num <= k) {
                            max = Math.max(num, max);
                            if (max == k) return k;
                        }
                    }
                }
            }
        }
        return max;
    }

}
