package day17;

import java.util.Stack;

public class Solution01 {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringBuilderStack = new Stack<>();
        stringBuilderStack.add(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int temp = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    temp = temp * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                numStack.push(temp);
                stringBuilderStack.push(new StringBuilder());
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
               stringBuilderStack.peek().append(s.charAt(i));
            } else if (s.charAt(i) == ']') {
                int temes = numStack.pop();
                StringBuilder stringBuilder = stringBuilderStack.pop();
                System.out.println(temes + " :" + stringBuilder);
                StringBuilder s1 = new StringBuilder();
                for (int j = 0; j < temes; j++) {
                    s1.append(stringBuilder);
                }
                stringBuilderStack.peek().append(s1);
            }
        }
        return stringBuilderStack.peek().toString();
    }
}
