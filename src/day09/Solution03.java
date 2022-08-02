package day09;

import java.util.Stack;

public class Solution03 {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {// 3+2*2
                int temp = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    temp = temp * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                numStack.push(temp);
            } else if (ch == '+') {
                charStack.push('+');
            } else if (ch == '-') {
                charStack.push('-');
            } else if (ch == '*') {
                i++;
                while (s.charAt(i) == ' ') {
                    i++;
                }
                char c = s.charAt(i);
                int temp = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    temp = temp * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                int num1 = numStack.pop();
                numStack.push(num1 * temp);
            } else if (ch == '/') {
                i++;
                while (s.charAt(i) == ' ') {
                    i++;
                }
                char c = s.charAt(i);
                int temp = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    temp = temp * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                int num1 = numStack.pop();
                numStack.push(num1 / temp);
            }
        }

        if (!charStack.isEmpty()) {
            Stack<Character> charStack1 = new Stack<>();
            while (!charStack.isEmpty()) {
                charStack1.push(charStack.pop());
            }
            Stack<Integer> numStack1 = new Stack<>();
            while (!numStack.isEmpty()) {
                numStack1.push(numStack.pop());
            }
            while (!charStack1.isEmpty()) {
                char ch = charStack1.pop();
                int num1 = numStack1.pop();
                int num2 = numStack1.pop();
                if (ch == '+') {
                    numStack1.push(num1 + num2);
                } else if (ch == '-'){
                    numStack1.push(num1 - num2);
                }
            }
            return numStack1.pop();
        }
        return numStack.pop();
    }
}
