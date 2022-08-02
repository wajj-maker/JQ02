package day09;

import java.util.Stack;

public class Solution08 {

}

class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> help;
    public MyQueue() {
        stack = new Stack<>();
        help = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
    }
    public int pop() {
        while (!stack.isEmpty()) {
            help.push(stack.pop());
        }
        int res = help.pop();
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
        return res;
    }
    public int peek() {
        while (!stack.isEmpty()) {
            help.push(stack.pop());
        }
        int res = help.peek();
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
        return res;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
