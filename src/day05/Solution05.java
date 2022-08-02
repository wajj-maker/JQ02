package day05;

import java.util.HashMap;
import java.util.Map;

public class Solution05 {
//    public boolean isIsomorphic(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        if (s.length() == 0 || s.length() == 1) {
//            return true;
//        }
//        return check(s, t);
//    }
//
//    public boolean check(String s, String t) {
//        Map<Character, Integer> map1 = new HashMap<>();
//        Map<Character, Integer> map2 = new HashMap<>();
//        map1.put(s.charAt(0), 0);
//        map2.put(t.charAt(0), 0);
//        for (int i = 1; i < s.length(); i++) {
//            if (map1.containsKey(s.charAt(i))) {
//                if (map2.containsKey(t.charAt(i)) == false) {
//                    return false;
//                }
//                if (map1.get(s.charAt(i)) != map2.get(t.charAt(i))) {
//                    return false;
//                }
//                map1.put(s.charAt(i), i);
//                map2.put(t.charAt(i), i);
//            } else {
//                if (map2.containsKey(t.charAt(i))) {
//                    return false;
//                }
//                map1.put(s.charAt(i), i);
//                map2.put(t.charAt(i), i);
//            }
//        }
//        return true;
//    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
