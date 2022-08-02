package day15;

public class Solution02 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[300][300];
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < n + 1; j++) {
            for (int i = j - 1; i >= 1; i--) {
                dp[i][j] = n * n;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }
}
