package day17;

public class Solution04 {
    public int integerReplacement(int n) {
        return integerReplacement1((long) n);
    }

    public int integerReplacement1(long n) {
        int num = 0;
        while (n > 1) {
            if ((n & 1) == 1) {
                return num + 1 + Math.min(integerReplacement1(n + 1), integerReplacement1(n - 1));
            } else {
                num++;
                n /= 2;
            }
        }
        return num;
    }

}
