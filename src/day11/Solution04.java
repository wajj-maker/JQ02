package day11;

import java.util.PriorityQueue;

public class Solution04 {

}

class MedianFinder {
    private PriorityQueue<Integer> maxQueue;
    private PriorityQueue<Integer> minQueue;
    public MedianFinder() {
        maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minQueue = new PriorityQueue<>();
    }
    public void addNum(int num) {
        maxQueue.offer(num);
        minQueue.offer(maxQueue.poll());
        if (minQueue.size() > maxQueue.size() + 1) {
            maxQueue.offer(minQueue.poll());
        }
    }
    public double findMedian() {
        if (maxQueue.size() != minQueue.size()) {
            return minQueue.peek();
        } else {
            return (maxQueue.peek() + minQueue.peek()) / 2.0;
        }
    }
}
