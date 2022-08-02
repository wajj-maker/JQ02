package day05;

public class Solution01 {
    public int reverseBits(int n) {
        String string = Integer.toBinaryString(n);
        StringBuilder reverse = new StringBuilder(string).reverse();
        String str = reverse.toString();
        int res = Integer.parseInt(str, 2);
        return res;
    }
}
