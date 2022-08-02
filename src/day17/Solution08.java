package day17;

import java.util.Stack;

public class Solution08 {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(num.charAt(0) - '0');
        for (int i = 1; i < num.length(); i++) {
            int now = num.charAt(i) - '0';
            while (!stack.isEmpty() && k > 0 && stack.peek() > now) {
                k--;
                stack.pop();
            }
            if (now != 0 || !stack.isEmpty()) {
                stack.push(now);
            }
        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
