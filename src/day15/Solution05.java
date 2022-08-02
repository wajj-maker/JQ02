package day15;

public class Solution05 {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int num = getLessMid(matrix, mid, matrix.length);
            if (num >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int getLessMid(int[][] matrix, int m, int n) {
        int y = n - 1;
        int x = 0;
        int res = 0;
        while (x < n) {
            while (y >= 0 && matrix[y][x] > m) {
                y--;
            }
            res += y + 1;
            x++;
        }
        return res;
    }
}
