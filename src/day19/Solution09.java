package day19;

import java.util.Arrays;

public class Solution09 {
    public int findContentChildren(int[] g, int[] s) {
        int num = 0;
        int index = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        for (int i = 0; i < s.length; i++) {
            if (index < g.length && s[i] >= g[index]) {
                num++;
                index++;
            }
        }
        return num;
    }
}
