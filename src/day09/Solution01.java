package day09;

import java.util.Stack;

public class Solution01 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int temp = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    temp = temp * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                res += sign * temp;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}
