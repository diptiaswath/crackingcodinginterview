package design;

import java.util.LinkedList;

// https://leetcode.com/problems/number-of-recent-calls/solution/
// Linked List Sliding Window
public class NumberOfRecentCalls {
    LinkedList<Integer> requests;

    public NumberOfRecentCalls() {
        this.requests = new LinkedList<Integer>();
    }

    public int ping(int t) {
        System.out.println("Size of requests = " + requests.size());
        this.requests.addLast(t);

        // Retain only those that are in the sliding window [t - 3000, t]
        while (requests.getFirst() < t - 3000) {
            this.requests.removeFirst();
        }

        return requests.size();

    }

}
