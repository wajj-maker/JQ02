package day14;

public class Solution08 {
    public int getSum(int a, int b) {
        int sum = 0, carry = 0;
        sum = a ^ b;
        carry = (a & b) << 1;
        if (carry != 0) {
            return getSum(sum, carry);
        }
        return sum;
    }
}
