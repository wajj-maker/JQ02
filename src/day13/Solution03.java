package day13;

public class Solution03 {
    public boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");
        int num = 0;
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].equals("#")) {
                num++;
            } else {
                if (num >= 2) {
                    num--;
                } else {
                    return false;
                }
            }
        }
        return num == 1;
    }
}
