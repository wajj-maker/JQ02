package day11;

import java.util.HashMap;
import java.util.Map;

public class Solution02 {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> map = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (chars.length != strings.length) return false;
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                if (map.get(strings[i]) != chars[i]) {
                    return false;
                }
            } else {
                if (map.containsValue(chars[i])) {
                    return false;
                }
                map.put(strings[i], chars[i]);
            }
        }
        return true;
    }
}
