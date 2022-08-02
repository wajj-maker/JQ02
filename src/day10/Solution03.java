package day10;

public class Solution03 {
    public int addDigits(int num) {
        int temp = num;
        while (temp >= 10) {
            int n = temp;
            temp = 0;
            while (n > 0) {
                temp += n % 10;
                n /= 10;
            }
        }
        return temp;
    }
}
