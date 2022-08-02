package day11;

import java.util.HashMap;
import java.util.Map;

public class Solution05 {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int a = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
                continue;
            }
            map1.put(secret.charAt(i), map1.getOrDefault(secret.charAt(i), 0) + 1);
            map2.put(guess.charAt(i), map2.getOrDefault(guess.charAt(i), 0) + 1);
        }
        int b = 0;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                b += Math.min(entry.getValue(), map2.get(entry.getKey()));
            }
        }
        return a + "A" + b + "B";
    }
}
