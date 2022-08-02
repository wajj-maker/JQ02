package day10;

public class Solution06 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        if (n == 1) return 1;
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] % 2 == 0) {
                p2++;
            }
            if (dp[i] % 3 == 0) {
                p3++;
            }
            if (dp[i] % 5 == 0) {
                p5++;
            }
        }
        return dp[n - 1];
    }
}
