package day18;

public class Solution10 {
    public int compress(char[] chars) {
        int num = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            num++;
            if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                stringBuilder.append(chars[i]);
                if (num > 1) {
                    stringBuilder.append(num);
                }
                num = 0;
            }
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            chars[i] = stringBuilder.charAt(i);
        }
        return stringBuilder.length();
    }
}
