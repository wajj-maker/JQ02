package day16;

import java.util.ArrayList;
import java.util.List;

public class Solution07 {
    private int n;
    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(res, i);
        }
        return res;
    }

    public void dfs(List<Integer> res, int k) {
        if (k > n) return;
        res.add(k);
        if (k * 10 > n) return;
        for (int i = 0; i < 10; i++) {
            dfs(res, k * 10 + i);
        }
    }
}
