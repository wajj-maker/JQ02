package day09;

public class Solution07 {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & -n) == n;
    }
}
