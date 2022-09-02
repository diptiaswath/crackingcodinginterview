package heaps;

import java.util.PriorityQueue;

public class KthLargestElement {

    // use a min heap with elements in asc order
    // with a heap, order in asc

    // Adding an element to a heap of size k is O(log k) and we do for n elements. O(N log k)
    // space complexity is O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep kth largest elements in the heap
        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }


}
