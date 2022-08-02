package day12;

import java.util.HashMap;
import java.util.Map;

public class Solution06 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];
        dp[0] = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < primes.length; i++) {
            map.put(primes[i], 0);
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], dp[map.get(primes[j])] * primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] % primes[j] == 0) {
                    map.put(primes[j], map.getOrDefault(primes[j], 0) + 1);
                }
            }
        }
        return (int)dp[n - 1];
    }
}
