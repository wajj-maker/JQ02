package day18;

import java.util.HashMap;
import java.util.Map;

public class Solution01 {
//    public int longestPalindrome(String s) {
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int res = getLongest(s, i);
//            if (res > max) {
//                max = res;
//            }
//            if (i + 1 < s.length()) {
//                int re = getLongest(s, i, i + 1);
//                if (re > max) {
//                    max = re;
//                }
//            }
//        }
//        return max;
//    }
//
//    public int getLongest(String s, int index) {
//        int num = 1;
//        int left = index - 1;
//        int right = index + 1;
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            num += 2;
//            left--;
//            right++;
//        }
//        return num;
//    }
//
//    public int getLongest(String s, int left, int right) {
//        int num = 0;
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            num += 2;
//            left--;
//            right++;
//        }
//        return num;
//    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int num = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if ((entry.getValue() & 1) == 1) {
                num++;
            }
        }
        if (num == 0) {
            return s.length();
        } else {
            return s.length() - num + 1;
        }
    }
}
