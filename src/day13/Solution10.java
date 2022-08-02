package day13;

import java.util.ArrayList;
import java.util.List;

public class Solution10 {
}

class SummaryRanges {
    private int[] arr = new int[10001];
    private int index;
    public SummaryRanges() {
        arr[0] = Integer.MAX_VALUE;
        index = 1;
    }
    public void addNum(int val) {
        int j = index - 1;
        while (j >= 0 && arr[j] > val) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = val;
        index++;
    }
    public int[][] getIntervals() {
        if (index == 1) {
            return new int[0][];
        }
        List<int[]> list = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < index - 1; i++) {
            if (i == index - 2) {
                list.add(new int[]{arr[left], arr[i]});
                continue;
            }
            if (arr[i] + 1 != arr[i + 1] && arr[i] != arr[i + 1]) {
                list.add(new int[]{arr[left], arr[i]});
                left = i + 1;
            }
        }
        int[][] res = new int[list.size()][];
        int a = 0;
        for (int[] ar : list) {
            res[a++] = ar;
        }
        return res;
    }
}
