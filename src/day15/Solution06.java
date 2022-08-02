package day15;

import java.util.*;

public class Solution06 {

}

class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index, last);
        list.remove(list.size() - 1);
        map.put(last, index);
        map.remove(val);
        return true;
    }
    public int getRandom() {
        int rand = random.nextInt(list.size());
        return list.get(rand);
    }
}
