package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution10 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(i);
        }
        int[][] res = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            int index = list.get(people[i][1]);
            list.remove(people[i][1]);
            res[index] = people[i];
        }
        return res;
    }
}
