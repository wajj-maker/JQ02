package day10;

public class Solution10 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right  = n;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (isBadVersion(mid)) {
//                if (mid - 1 < 0 || isBadVersion(mid - 1) == false) {
//                    return mid;
//                }
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
        return left;
    }
}
