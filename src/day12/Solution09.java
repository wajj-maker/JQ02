package day12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution09 {
    public int maxProduct(String[] words) {
        int max = 0;
        int[][] check = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (Character cher : words[i].toCharArray()) {
                check[i][cher - 'a']++;
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (check(check, i, j)) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }

    public boolean check(int[][] check, int a, int b) {
        for (int i = 0; i < 26; i++) {
            if (check[a][i] != 0 && check[b][i] != 0) {
                return false;
            }
        }
        return true;
    }
}
