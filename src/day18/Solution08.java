package day18;

public class Solution08 {
    public int arrangeCoins(int n) { // mid * (1 + mid) / 2 <= n
        long n1 = n;
        long left = 1;
        long right = 1000;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * (mid + 1) / 2 <= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int)left - 1;
    }
}
