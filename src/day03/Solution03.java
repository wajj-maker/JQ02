package day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution03 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (min < prices[i]) {
                res += prices[i] - min;
                list.add(prices[i] - min);
                min = prices[i];
            }
        }
        if (list.size() > k) {
            Collections.sort(list);
            for (int i = 0; i < list.size() - k; i++) {
                res -= list.get(i);
            }
        }
        return res;
    }
}
