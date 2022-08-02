package day19;

import java.util.*;

public class Solution04 {
    public String originalDigits(String s) { // nine
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        while (map.size() > 0) {
            if (map.get('z') != null) {
                int num = map.get('z');
                for (int i = 0; i < num; i++) {
                    list.add(0);
                }
                map.remove('z');
                map.put('e', map.getOrDefault('e', 0) - num);
                if (map.get('e') == 0) {
                    map.remove('e');
                }
                map.put('r', map.getOrDefault('r', 0) - num);
                if (map.get('r') == 0) {
                    map.remove('r');
                }
                map.put('o', map.getOrDefault('o', 0) - num);
                if (map.get('o') == 0) {
                    map.remove('o');
                }
            } else if (map.get('x') != null) {
                int num = map.get('x');
                for (int i = 0; i < num; i++) {
                    list.add(6);
                }
                map.remove('x');
                map.put('s', map.getOrDefault('s', 0) - num);
                if (map.get('s') == 0) {
                    map.remove('s');
                }
                map.put('i', map.getOrDefault('i', 0) - num);
                if (map.get('i') == 0) {
                    map.remove('i');
                }
            } else if (map.get('g') != null) {
                int num = map.get('g');
                for (int i = 0; i < num; i++) {
                    list.add(8);
                }
                map.remove('g');
                map.put('e', map.getOrDefault('e', 0) - num);
                if (map.get('e') == 0) {
                    map.remove('e');
                }
                map.put('i', map.getOrDefault('i', 0) - num);
                if (map.get('i') == 0) {
                    map.remove('i');
                }
                map.put('h', map.getOrDefault('h', 0) - num);
                if (map.get('h') == 0) {
                    map.remove('h');
                }
                map.put('t', map.getOrDefault('t', 0) - num);
                if (map.get('t') == 0) {
                    map.remove('t');
                }
            } else if (map.get('s') != null) {
                int num = map.get('s');
                for (int i = 0; i < num; i++) {
                    list.add(7);
                }
                map.remove('s');
                map.put('e', map.getOrDefault('e', 0) - 2 * num);
                if (map.get('e') == 0) {
                    map.remove('e');
                }
                map.put('v', map.getOrDefault('v', 0) - num);
                if (map.get('v') == 0) {
                    map.remove('v');
                }
                map.put('n', map.getOrDefault('n', 0) - num);
                if (map.get('n') == 0) {
                    map.remove('n');
                }
            } else if (map.get('v') != null) {
                int num = map.get('v');
                for (int i = 0; i < num; i++) {
                    list.add(5);
                }
                map.remove('v');
                map.put('f', map.getOrDefault('f', 0) -  num);
                if (map.get('f') == 0) {
                    map.remove('f');
                }
                map.put('i', map.getOrDefault('i', 0) - num);
                if (map.get('i') == 0) {
                    map.remove('i');
                }
                map.put('e', map.getOrDefault('e', 0) - num);
                if (map.get('e') == 0) {
                    map.remove('e');
                }
            } else if (map.get('f') != null) {
                int num = map.get('f');
                for (int i = 0; i < num; i++) {
                    list.add(4);
                }
                map.remove('f');
                map.put('o', map.getOrDefault('o', 0) -  num);
                if (map.get('o') == 0) {
                    map.remove('o');
                }
                map.put('u', map.getOrDefault('u', 0) - num);
                if (map.get('u') == 0) {
                    map.remove('u');
                }
                map.put('r', map.getOrDefault('r', 0) - num);
                if (map.get('r') == 0) {
                    map.remove('r');
                }
            } else if (map.get('w') != null) {
                int num = map.get('w');
                for (int i = 0; i < num; i++) {
                    list.add(2);
                }
                map.remove('w');
                map.put('t', map.getOrDefault('t', 0) -  num);
                if (map.get('t') == 0) {
                    map.remove('t');
                }
                map.put('o', map.getOrDefault('o', 0) - num);
                if (map.get('o') == 0) {
                    map.remove('o');
                }
            } else if (map.get('o') != null) {
                int num = map.get('o');
                for (int i = 0; i < num; i++) {
                    list.add(1);
                }
                map.remove('o');
                map.put('n', map.getOrDefault('n', 0) -  num);
                if (map.get('n') == 0) {
                    map.remove('n');
                }
                map.put('e', map.getOrDefault('e', 0) - num);
                if (map.get('e') == 0) {
                    map.remove('e');
                }
            } else if (map.get('t') != null) {
                int num = map.get('t');
                for (int i = 0; i < num; i++) {
                    list.add(3);
                }
                map.remove('t');
                map.put('h', map.getOrDefault('h', 0) -  num);
                if (map.get('h') == 0) {
                    map.remove('h');
                }
                map.put('r', map.getOrDefault('r', 0) - num);
                if (map.get('r') == 0) {
                    map.remove('r');
                }
                map.put('e', map.getOrDefault('e', 0) - 2 * num);
                if (map.get('e') == 0) {
                    map.remove('e');
                }
            } else if (map.get('i') != null) {
                int num = map.get('i');
                for (int i = 0; i < num; i++) {
                    list.add(9);
                }
                map.remove('i');
                map.put('n', map.getOrDefault('n', 0) -  2 * num);
                if (map.get('n') == 0) {
                    map.remove('n');
                }
                map.put('e', map.getOrDefault('e', 0) - num);
                if (map.get('e') == 0) {
                    map.remove('e');
                }
            }
        }
        Collections.sort(list);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : list) {
            stringBuilder.append(integer);
        }
        return stringBuilder.toString();
    }
}
