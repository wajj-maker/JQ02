package day01;

public class Solution02 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int n = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int num = columnTitle.charAt(i) - 'A';
            res += (num + 1) * n;
            n *= 26;
        }
        return res;
    }
}
