package day08;

import java.util.ArrayList;
import java.util.List;

public class Solution02 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, k, n, 1);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i < 10; i++) {
            if (n - i >= 0) {
                list.add(i);
                dfs(res, list, k - 1, n - i, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
