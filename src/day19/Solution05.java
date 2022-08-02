package day19;

public class Solution05 {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int[] arr = new int[26];
        while (right < s.length()) {
            arr[s.charAt(right) - 'A']++;
            max = Math.max(max, arr[s.charAt(right) - 'A']);
            while (right - left + 1 - max > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
