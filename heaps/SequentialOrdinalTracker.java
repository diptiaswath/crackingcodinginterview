package heaps;

import java.util.PriorityQueue;

class Location {
    String name;
    Integer score;

    public Location(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
}

// Tricky problem [DOES NOT WORK for all use cases, I have not understood this fully]
//https://leetcode.com/problems/sequentially-ordinal-rank-tracker/
public class SequentialOrdinalTracker {

    private PriorityQueue<Location> maxHeap; // max heap for higher scores
    private PriorityQueue<Location> minHeap; // min heap

    //The size of the max heap is k + 1 (best locations), where k is the number of times the get method was invoked. The other locations are maintained in the right heap.
    public SequentialOrdinalTracker() {
        this.maxHeap = new PriorityQueue<>((a, b) -> a.score == b.score ? a.name.compareTo(b.name) : b.score - a.score); // max heap (left)
        this.minHeap = new PriorityQueue<>((a, b) -> a.score == b.score ? b.name.compareTo(a.name) : a.score - b.score); // min heap (right)

    }

    //Every time when add is being called, we add it to the max heap. If the size of the max heap exceeds k + 1, we move the head element to the right heap.
    public void add(String name, int score) {
        minHeap.offer(new Location(name, score));
        maxHeap.offer(minHeap.poll());
    }

    //When the get method is invoked again (the k + 1 time it is invoked), we can return the head element of the max heap. But before returning it, if the min heap is not empty, we maintain the max heap to have the best k + 2 items by moving the best location from the right heap to the left heap.
    public String get() {
        Location loc = maxHeap.poll();
        minHeap.offer(loc);
        return loc.name;
    }
}

