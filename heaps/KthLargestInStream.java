package heaps;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/solution/
// use solution https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-kth-largest-element-in-a-stream
public class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);
    private int k;

    // Constructor to initialize heap and add values in it
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int element : nums) {
            add(element); // TIP: KEEP NOTE OF THIS.
        }
    }

    // Adds element in the heap and return the Kth largest
    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
