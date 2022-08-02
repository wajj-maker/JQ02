package day17;

public class Solution09 {
    public String toHex(int num) {
        char[] list = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder stringBuilder = new StringBuilder();
        if (num == 0) {
            return "0";
        }
        long num2 = num;
        if (num2 < 0) {
            num2 = num2 + (long)Math.pow(16, 8);
        }
        while (num2 > 0) {
            long index = num2 % 16;
            stringBuilder.append(list[(int)index]);
            num2 /= 16;
        }
        return stringBuilder.reverse().toString();
    }
}
