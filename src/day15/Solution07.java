package day15;

import java.util.*;

public class Solution07 {

}

class RandomizedCollection {
    private Map<Integer, List<Integer>> map;
    private List<Integer> list;
    private Random random;
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    public boolean insert(int val) {
        boolean flag = map.containsKey(val);
        if (map.get(val) == null) {
            List<Integer> lis = new ArrayList<>();
            map.put(val, lis);
        }
        list.add(val);
        map.get(val).add(list.size() - 1);
        return flag;
    }
    public boolean remove(int val) {
        boolean flag = map.containsKey(val);
        if (!flag) {
            return flag;
        }
        List<Integer> lis = map.get(val);
        if (list.get(list.size() - 1) == val) {
            list.remove(list.size() - 1);
            lis.remove(lis.size() - 1);
            if (lis.size() == 0) {
                map.remove(val);
            }
        } else {
            int index = lis.get(lis.size() - 1);
            // map.get(list.get(list.size() - 1)).set(map.get(list.get(list.size() - 1)).size() - 1, index);
            int last = list.size() - 1;
            int temp = list.get(index);
            list.set(index, list.get(last));
            list.set(last, temp);
            lis.remove(lis.size() - 1);
            if (lis.size() == 0) {
                map.remove(val);
            }
            List<Integer> ls = map.get(list.get(index));
            ls.remove(ls.size() - 1);
            ls.add(index);
            Collections.sort(ls);
            list.remove(list.size() - 1);
        }
        return flag;
    }
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
