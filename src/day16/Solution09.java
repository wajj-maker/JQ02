package day16;

import java.util.HashMap;
import java.util.Map;

public class Solution09 {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
            if (map.get(s.charAt(i)) == 0) {
                map.remove(s.charAt(i));
            }
        }
        char c = 'a';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            c = entry.getKey();
        }
        return c;
    }
}
