package day13;

public class Solution08 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            while (l < r && chars[l] != 'a' && chars[l] != 'A' && chars[l] != 'e' && chars[l] != 'E' && chars[l] != 'i'
            && chars[l] != 'I' && chars[l] != 'o' && chars[l] != 'O' && chars[l] != 'u' && chars[l] != 'U') {
                l++;
            }
            while (l < r && chars[r] != 'a' && chars[r] != 'A' && chars[r] != 'e' && chars[r] != 'E' && chars[r] != 'i'
                    && chars[r] != 'I' && chars[r] != 'o' && chars[r] != 'O' && chars[r] != 'u' && chars[r] != 'U') {
                r--;
            }
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
