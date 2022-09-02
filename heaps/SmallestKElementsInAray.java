package heaps;

import java.util.PriorityQueue;

public class SmallestKElementsInAray {

    // always a max heap, where largest element is at top of heap
    // Cracking the Coding Interview Pg 566

    public int[] smallestK(int[] nums, int k) {

        // largest element is at top of heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (num < heap.peek()) {
                heap.poll();
                heap.add(num);
            }
        }

        int[] newA = new int[k];
        for (int i = k - 1; k >=0; i--) {
            newA[i] = heap.poll();
        }
        return newA;
    }

}
