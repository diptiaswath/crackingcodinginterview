package heaps;

import java.util.PriorityQueue;
// https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/1308938263/
public class KthLargestElement {

    // use a min heap with elements in asc order
    // with a heap, order in asc

    // Adding an element to a heap of size k is O(log k) and we do for n elements. O(N log k)
    // space complexity is O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        for (int num: nums) {
            if (heap.size() < k) {
                heap.offer(num);
            } else if (num > heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        return heap.peek();
    }


}
