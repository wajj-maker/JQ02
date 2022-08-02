package day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution01 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) < envelopes[i][1]) {
                list.add(envelopes[i][1]);
                continue;
            } else {
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (list.get(mid) >= envelopes[i][1]) {
                        right = mid;
                    } else if (list.get(mid) < envelopes[i][1]) {
                        left = mid + 1;
                    }
                }
                list.set(left, envelopes[i][1]);
            }
        }
        return list.size();
    }
}
