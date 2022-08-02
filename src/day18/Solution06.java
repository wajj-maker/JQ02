package day18;

import java.util.ArrayList;
import java.util.List;

public class Solution06 {
    public Node flatten(Node head) {
        if (head == null) return null;
        List<Node> list = new ArrayList<>();
        flatten(head, list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).val);
        }
        Node node = list.get(0);
        node.prev = null;
        node.child = null;
        if (list.size() != 1) {
            node.next = list.get(1);
        }
        for (int i = 1; i < list.size(); i++) {
            if (i != list.size() - 1) {
                list.get(i).next = list.get(i + 1);
            }
            if (i == list.size() - 1) {
                list.get(i).next = null;
            }
            list.get(i).prev = list.get(i - 1);
            list.get(i).child = null;
        }
        return node;
    }

    public void flatten(Node head, List<Node> list) {
        Node temp = head;
        while (temp != null) {
            list.add(temp);
            if (temp.child != null) {
                flatten(temp.child, list);
            }
            if (temp.next == null) break;
            temp = temp.next;
        }
    }
}
