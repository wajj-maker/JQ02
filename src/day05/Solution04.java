package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution04 {
    public int countPrimes(int n) {
        boolean[] check = new boolean[n];
        Arrays.fill(check, true);
        for (int i = 2; i * i < n; i++) {
            if (check[i]) {
                for (int j = i * i; j < n; j += i) {
                    check[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (check[i]) count++;
        }
        return count;
    }
}
