// Approach is a mix of LeetCode and educative.io
// Maintain two heaps, one for small nums which is in maxHeap. Largest of all nums is on top of max Heap
// Then for large nums which is in minHeap. Smallest of all large nums is on top of minHeap
// https://leetcode.com/problems/find-median-from-data-stream/
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/find-median-from-a-data-stream
// O(log N)
class MedianOfStream {
    private PriorityQueue<Integer> maxHeapForSmallNums;
    private PriorityQueue<Integer> minHeapForLargeNums;

    public MedianOfStream() {
        this.maxHeapForSmallNums = new PriorityQueue<>((a,b) -> b - a);
        this.minHeapForLargeNums = new PriorityQueue<>((a, b) -> a - b);
    }

    // Move the maximum element from the max-heap to the min-heap:
    // You immediately move the largest element from the max-heap to the min-heap.
    // This ensures that the max-heap only contains elements less than or equal to those in the min-heap.
    // Rebalance the heaps if necessary:
    // If the min-heap (minHeapForLargeNums) has more elements than the max-heap, you move the smallest
    // element from the min-heap back to the max-heap to maintain the size property.
    public void insertNum(int num) {
        maxHeapForSmallNums.add(num);
        minHeapForLargeNums.add(maxHeapForSmallNums.poll());
        if (minHeapForLargeNums.size() > maxHeapForSmallNums.size()) {
            maxHeapForSmallNums.add(minHeapForLargeNums.poll());
        }

    }

    public double findMedian() {
        if (maxHeapForSmallNums.size() == minHeapForLargeNums.size()) {
            return (maxHeapForSmallNums.peek() + minHeapForLargeNums.peek())/2.0;
        }
        return maxHeapForSmallNums.peek();
    }
}