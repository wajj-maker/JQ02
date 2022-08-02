package day09;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution02 {

}

class MyStack {
    Deque<Integer> queue = new LinkedList<>();
    public MyStack() {
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        return queue.pollLast();
    }

    public int top() {
        return queue.getLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
