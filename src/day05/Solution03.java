package day05;

import java.util.HashSet;
import java.util.Set;

public class Solution03 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            if (set.contains(n)) break;
            set.add(n);
        }
        return n == 1 ? true : false;
    }
}
