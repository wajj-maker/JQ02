package day14;

public class Solution06 {
    public boolean isPerfectSquare(int num) {
        int n = 1;
        while (n < num / n) {
            n *= 2;
        }
        if (num % n == 0 && n == num / n) return true;
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > num / mid) {
                right = mid - 1;
            } else if (mid < num / mid) {
                left = mid + 1;
            } else {
                return num % mid == 0;
            }
        }
        return false;
    }
}
