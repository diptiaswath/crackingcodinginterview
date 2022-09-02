package design;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/design-hit-counter/solution/
public class HitCounterQueue {
    private Queue<Integer> hitsQ;

    public HitCounterQueue() {
        this.hitsQ = new LinkedList<Integer>();
    }

    public void hit(int timestamp) {
        this.hitsQ.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!this.hitsQ.isEmpty()) {
            int delta = timestamp - this.hitsQ.peek();
            if (delta >= 300) {
                this.hitsQ.remove();
            } else {
                break; // DO NOT FORGET THIS
            }
        }
        return this.hitsQ.size();
    }
}
