package day16;

import java.util.*;

public class Solution06 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Set<String>>> map = new HashMap<>();
        for (List<String> list : accounts) {
            String name = list.get(0);
            if (map.containsKey(name)) {
                List<Set<String>> list2 = map.get(name);
                boolean flag = false;
                List<Integer> lo = new ArrayList<>();
                int index = 0;
                for (Set<String> set : list2) {
                    for (int i = 1; i < list.size(); i++) {
                        if (set.contains(list.get(i))) {
                            flag = true;
                            lo.add(index);
//                            for (int j = 1; j < list.size(); j++) {
//                                set.add(list.get(j));
//                            }
                            break;
                        }
                    }
//                    if (flag) break;
                    index++;
                }
                if (flag) {
                    Set<String> set = new HashSet<>();
                    Set<Integer> set1 = new HashSet<>();
                    for (int i = 0; i < lo.size(); i++) {
                        set.addAll(list2.get(lo.get(i)));
                        set1.add(lo.get(i));
                    }
                    for (int j = 1; j < list.size(); j++) {
                        set.add(list.get(j));
                    }
                    List<Set<String>> list5 = new ArrayList<>();
                    list5.add(set);
                    for (int i = 0; i < list2.size(); i++) {
                        if (!set1.contains(i)) {
                            list5.add(list2.get(i));
                        }
                    }
                    map.put(name, list5);
                }
                if (!flag) {
                    Set<String> set = new HashSet<>();
                    for (int i = 1; i < list.size(); i++) {
                        set.add(list.get(i));
                    }
                    list2.add(set);
                }
            } else {
                Set<String> set = new HashSet<>();
                for (int i = 1; i < list.size(); i++) {
                    set.add(list.get(i));
                }
                List<Set<String>> l = new ArrayList<>();
                l.add(set);
                System.out.println(l);
                map.put(name, l);
                System.out.println(map);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<Set<String>>> entry : map.entrySet()) {
            List<Set<String>> list3 = entry.getValue();
            for (Set<String> set : list3) {
                List<String> list4 = new ArrayList<>();
                list4.addAll(set);
                Collections.sort(list4);
                List<String> list5 = new ArrayList<>();
                list5.add(entry.getKey());
                list5.addAll(list4);
                res.add(list5);
            }
        }
        return res;
    }
}
