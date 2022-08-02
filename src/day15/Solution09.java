package day15;

import java.util.HashMap;
import java.util.Map;

public class Solution09 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i))) {
                return false;
            }
            map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            if (map.get(ransomNote.charAt(i)) == 0) {
                map.remove(ransomNote.charAt(i));
            }
        }
        return true;
    }
}
