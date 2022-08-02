package day19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution08 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Helper[] arr = new Helper[map.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            arr[index] = new Helper();
            arr[index].key = entry.getKey();
            arr[index].value = entry.getValue();
            index++;
        }
        Arrays.sort(arr, (o1, o2) -> o2.value - o1.value);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].value; j++) {
                stringBuilder.append(arr[i].key);
            }
        }
        return stringBuilder.toString();
    }
}

class Helper {
    char key;
    int value;
}
