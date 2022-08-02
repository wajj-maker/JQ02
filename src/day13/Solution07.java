package day13;

public class Solution07 {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        int[] dp = new int[n + 1];
        int max = 0;
        dp[2] = 1;
        dp[1] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
