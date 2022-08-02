package day03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution02 {
    public List<String> findRepeatedDnaSequences(String s) { // "AAAAAAAAAAA"
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if (set1.contains(str)) {
                set2.add(str);
            } else {
                set1.add(str);
            }
        }
        return new ArrayList<>(set2);
    }
}
