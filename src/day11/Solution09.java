package day11;

public class Solution09 {
    public void reverseString(char[] s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            stringBuilder.append(s[i]);
        }
        stringBuilder.reverse();
        for (int i = 0; i < s.length; i++) {
            s[i] = stringBuilder.charAt(i);
        }
    }
}
