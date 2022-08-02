package day12;

public class Solution10 {
    public int bulbSwitch(int n) {
        // 3 1  5 2  7 3  9 4
        int num = 1;
        int step = 3;
        int sum = 0;
        while (n > sum) {
            sum += step;
            step += 2;
            num++;
        }
        return num - 1;
    }

}
