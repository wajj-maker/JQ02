package day12;

import java.util.Stack;

public class Solution08 {
    public String removeDuplicateLetters(String s) { // "cbacdcbc"
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.contains(s.charAt(i))) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
