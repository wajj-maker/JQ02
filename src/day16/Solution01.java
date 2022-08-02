package day16;

import java.util.ArrayList;
import java.util.List;
// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation

public class Solution01 {
    public int countAsterisks(String s) {
        int res = 0;
        int step = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                step++;
            } else if (step % 2 == 0 && s.charAt(i) == '*') {
                res++;
            }
        }
        return res;
    }
}



