package day05;

public class Solution02 {
    public int rangeBitwiseAnd(int left, int right) {
        if (Integer.toBinaryString(left).length() != Integer.toBinaryString(right).length()) {
            return 0;
        }
        if (left == right) return left;
        long res = left;
        for (long i = left + 1; i <= right; i++) {
            res &= i;
        }
        return (int)res;
    }
}
