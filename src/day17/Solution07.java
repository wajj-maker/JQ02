package day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution07 {
    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn < 0 || turnedOn > 8) return new ArrayList<>();
        if (turnedOn == 0) {
            List<String> list = new ArrayList<>();
            String str = "0:00";
            list.add(str);
            return list;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (count(i) + count(j) == turnedOn) {
                    list.add(i + ":" + (j < 10 ? ("0" + j) : j));
                }
            }
        }
        return list;
    }

    public int count(int x) {
        return Integer.bitCount(x);
    }
}
