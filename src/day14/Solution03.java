package day14;

public class Solution03 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int sum = 10;
        int num = 9;
        int temp = 9;
        while (n > 1) {
            n--;
            sum = temp * num + sum;
            temp *= num;
            num--;
        }
        return sum;
    }
}
