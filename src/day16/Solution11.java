package day16;

import java.util.Arrays;

public class Solution11 {
    public boolean validUtf8(int[] data) {
        String[] strings = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            String str = Integer.toBinaryString(data[i]);
            if (str.length() < 8) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < 8 - str.length(); j++) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(str.toCharArray());
                strings[i] = stringBuilder.toString();
            } else {
                strings[i] = str;
            }
        }
        boolean flag = true;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].startsWith("0")) {
                continue;
            } else if (strings[i].startsWith("110")) {
                if (i + 1 < strings.length && strings[i + 1].startsWith("10")) {
                    i = i + 1;
                    continue;
                } else {
                    return false;
                }
            } else if (strings[i].startsWith("1110")) {
                if (i + 2 < strings.length && strings[i + 1].startsWith("10") && strings[i + 2].startsWith("10")) {
                    i = i + 2;
                    continue;
                } else {
                    return false;
                }
            } else if (strings[i].startsWith("11110")) {
                if (i + 3 < strings.length && strings[i + 1].startsWith("10") && strings[i + 2].startsWith("10") && strings[i + 3].startsWith("10")) {
                    i = i + 3;
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
