package day16;

public class Solution10 {
    public int lastRemaining(int n) {
        int first = 1; // 表示每次消除时的首元素
        int step = 1; // 记录首元素的下一个元素
        int num = n; // 表示元素的个数
        boolean flag = false; // 负数表示从左到右
        while (num > 1) {
            if (!flag || (num & 1) == 1) {
                first += step;
            }
            step = step << 1;
            num = num >> 1;
            flag = !flag;
        }
        return first;
    }
}
