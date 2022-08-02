package day17;

public class Solution02 {
    public int longestSubstring(String s, int k) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] < k) {
                return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(i + 1), k));
            }
        }
        return s.length();
    }
}
