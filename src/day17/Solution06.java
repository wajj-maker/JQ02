package day17;

import java.util.Arrays;

public class Solution06 {
    private long[] arr;
    public Solution06() {
        arr = new long[12]; // 4
        arr[1] = 9;
        int num = 2;
        int step = 10;
        while (num < 11) {
            arr[num] = arr[num - 1] + (long)(step * 9 * (num));
            num++;
            step *= 10;
        }
    }
    public int findNthDigit(int n) { // 11
        System.out.println(Arrays.toString(arr));
        if (n < 10) return n;
        int index = 1;
        while (n > arr[index]) {
            index++;
        }
        n = (int)(n - arr[index - 1]); // 11   1 2 3 4 5 6 7 8 9 10 11
        int num = n / index; // 11
        int nu = 1;
        int temp = index;
        while (index > 1) {
            nu *= 10;
            index--;
        }
        num = nu + num - 1;
        if (n % temp == 0) {
            return num % 10;
        } else {
            int res = (num + 1 + "").charAt(n % (temp) - 1) - '0';
            return res;
        }
    }
}
