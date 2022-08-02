package day15;

public class Solution01 {
        public int guessNumber(int n) {
            int left = 1;
            int right = n;
            while (left <= right) { // 10
                int mid = left + (right - left) / 2;
                System.out.println(mid);
                if (guess(mid) == 1) {
                    left = mid + 1;
                } else if (guess(mid) == -1) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }

    public int guess(int num) {
        return 0;
    }
}
