package day18;

public class Solution07 {
    public int countSegments(String s) {
        String[] s1 = s.split(" ");
        int num = 0;
        for (int i = 0; i < s1.length; i++) {
            if (!s1[i].startsWith(" ") && !s1[i].equals("")) {
                num++;
            }
        }
        return num;
    }
}
