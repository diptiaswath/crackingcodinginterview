package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent {

    // https://leetcode.com/problems/top-k-frequent-elements/solution/
    // USE educative.io solution https://www.educative.io/courses/grokking-coding-interview-patterns-java/top-k-frequent-elements
    public static List<Integer> topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // Build a element freq map
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Init a min heap pq that is added by freq in ascending order, so the smallest of the largest frequencies is on top
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b)-> a.getValue() - b.getValue());

        // Add Map.Entry of freqMap to pq of size k. Add the top k frequent elements into heap
        // It adds each Map.Entry from map into minHeap. If the size of minHeap exceeds
        //k, it removes the smallest element (least frequent) because of the min heap property.
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Add to list the top elements, discard freq
        // It adds each Map.Entry from map into minHeap. If the size of minHeap exceeds
        //k, it removes the smallest element (least frequent) because of the min heap property.
        List<Integer> topNumbers = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }
        return topNumbers;
    }
}
