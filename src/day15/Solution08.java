package day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution08 {
    private List<Integer> list = new ArrayList<>();
    private Random random;
    public Solution08(ListNode head) {
        ListNode temp = head;
        while (true) {
            list.add(temp.val);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
