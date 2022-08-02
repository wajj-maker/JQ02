package day01;

public class Solution03 {
    public int trailingZeroes(int n) {
        int num = 0;
        while (n >= 5) {
            num += n / 5;
            n = n / 5;
        }
        return num;
    }
}
