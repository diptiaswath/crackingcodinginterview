package heaps;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/solution/
public class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            pq.offer(num);

        }

        while (pq.size() > k) {
            pq.poll();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
