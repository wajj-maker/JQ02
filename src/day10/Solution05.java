package day10;

public class Solution05 {
    public boolean isUgly(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 2) {
            return false;
        }
        while (n != 2 && n != 3 && n != 5) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return n == 2 || n == 3 || n == 5;
    }
}
