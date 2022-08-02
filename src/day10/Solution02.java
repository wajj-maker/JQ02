package day10;

import java.util.Arrays;
import java.util.Collections;

public class Solution02 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] != chars1[i]) {
                return false;
            }
        }
        return true;
    }
}
