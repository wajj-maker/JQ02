package day12;

import java.util.*;

public class Solution02 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        boolean flag = false;
        Set<String> set = new HashSet<>(); // ����set��Ϊ�����Ч��
        set.add("");
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if (isCheck(temp)) {
                list.add(temp);
                flag = true;
            }
            if (flag) { // ������Ҫ ������bfs��˼��  �ҵ��˸�����  ˵�����治���ټ���
                continue;
            }
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '(' || temp.charAt(i) == ')') {
                    String str;
                    str = temp.substring(0, i) + temp.substring(i + 1);
                    if (set.add(str)) {
                        queue.offer(str);
                    }
                }
            }
        }
        if (list.isEmpty()) {
            list.add("");
        }
        return list;
    }

    public boolean isCheck(String str) {
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
            } else if (str.charAt(i) == ')') {
                if (left <= 0) {
                    return false;
                } else {
                    left--;
                }
            }
        }
        return left == 0;
    }
}
