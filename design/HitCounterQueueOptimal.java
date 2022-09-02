package design;

import java.util.Deque;
import java.util.LinkedList;

class Pair<K, V> {
    K key;
    V value;
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

//https://leetcode.com/problems/design-hit-counter/solution/
public class HitCounterQueueOptimal {
    private Deque<Pair<Integer, Integer>> hits;
    private int total;

    public HitCounterQueueOptimal() {
        this.hits = new LinkedList<Pair<Integer, Integer>>();
        this.total = 0;
    }

    // Add hit at timestamp
    public void hit(int timestamp) {
        if (hits.isEmpty() || hits.getLast().key != timestamp) {
            hits.addLast(new Pair<Integer, Integer>(timestamp, 1));
        } else {
            int prevCount = hits.getLast().value;
            hits.removeLast();
            hits.addLast(new Pair<Integer, Integer>(timestamp, prevCount + 1));
        }
        this.total++;
    }

    // Get number of hits in past 5 mins
    public int getHits(int timestamp) {
        while (!this.hits.isEmpty()) {
            int delta = timestamp - hits.getFirst().key;
            if (delta >= 300) {
                this.total = total - hits.getFirst().value;
                hits.removeFirst();
            } else {
                break;
            }
        }
        return this.total;
    }
}
