package heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeight {

    //https://leetcode.com/problems/last-stone-weight/solution/
    // max heap where heaviest/largest stone is at top
    private PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);


    public int lastStoneWeight(int[] stones) {
        for (int weight: stones) {
            heap.offer(weight);
        }

        while (heap.size() > 1) {
            int yWeight = heap.poll();
            int xWeight = heap.poll();
            if (xWeight != yWeight) {
                heap.add(yWeight - xWeight);
            }
        }
        return heap.isEmpty() ? 0: heap.poll();
    }
}
