package breadthFirstSearch;

import java.util.*;

class PairBFS<T,K> {
    T key;
    K value;
    PairBFS(T key, K value) {
        this.key = key;
        this.value = value;
    }
    T getKey() {
        return this.key;
    }
    K getValue() {
        return this.value;
    }
}

//https://leetcode.com/problems/network-delay-time/solution/
public class NetworkDelayTime {

    // Approach1: Uses a BFS
    // Each of the N nodes can be added to the queue for all edges connected to it. Time complexity =  O(N*E)
    // Space Complexity: O (N. E)
    private Map<Integer, List<PairBFS<Integer, Integer>>> adjList = new HashMap<>();


    private void BFS(int[] signalReceivedAt, int sourceNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sourceNode);

        // Time for starting node is 0
        signalReceivedAt[sourceNode] = 0;

        while (!q.isEmpty()) {
            int currNode = q.remove();

            if (!adjList.containsKey(currNode)) {
                continue;
            }

            // Broadcast the signal to adjacent nodes
            for (PairBFS<Integer, Integer> edge : adjList.get(currNode)) {
                int time = edge.key;
                int neighborNode = edge.value;

                // Fastest signal time for neighborNode so far
                // signalReceivedAt[currNode] + time :
                // time when signal reaches neighborNode
                int arrivalTime = signalReceivedAt[currNode] + time;
                if (signalReceivedAt[neighborNode] > arrivalTime) {
                    signalReceivedAt[neighborNode] = arrivalTime;
                    q.add(neighborNode);
                }
            }
        }
    }


    public int networkDelayTime(int[][] times, int n, int k) {
        // Build the adjacency list
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adjList.putIfAbsent(source, new ArrayList<>());
            adjList.get(source).add(new PairBFS(travelTime, dest));
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        BFS(signalReceivedAt, k);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalReceivedAt[i]);
        }

        // INT_MAX signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
