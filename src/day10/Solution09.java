package day10;

public class Solution09 {
    public int hIndex(int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (h <= citations[i]) {
                return h;
            }
        }
        return 0;
    }
}
