package breadthFirstSearch;

// See the video on this page = https://leetcode.com/explore/featured/card/graph/622/single-source-shortest-path-algorithm/3862/
// https://leetcode.com/problems/network-delay-time/solution/

import java.util.*;

// objective: Find the fastest path from Node K to every other Node
// Time : O(N + E LOG N)
// Previous approach: We used a queue and broad-casted the signal from visited nodes in a FIFO manner.
// Djkstra's approach: Use a priority queue to traverse nodes in increasing order of time required to reach them.
// Ie., in each iteration, we will visit the node with shortest travel time. This will help us finding the fastest time path first
public class NetworkDelayTimeWithDjkstra {

    private Map<Integer, List<PairBFS<Integer, Integer>>> adjList = new HashMap<>();


    // Time: Dijkstra's Algorithm takes O(E log⁡N). Finding the minimum time required in signalReceivedAt takes O(N).
    // Space: O (N + E)
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create an adjacency list such that adj[source] contains all destination nodes the signal can travel to from source
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            adjList.putIfAbsent(source, new ArrayList<>());
            adjList.get(source).add(new PairBFS(travelTime, dest));
        }

        // For all nodes, initialize signalReceivedAt[node] = large value since the node has not received any signal yet
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        djkstra(signalReceivedAt, k);

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, signalReceivedAt[i]);
        }

        return (ans == Integer.MAX_VALUE? -1: ans);
    }

    private void djkstra(int[] signalReceivedAt, int sourceNode) {
        PriorityQueue<PairBFS<Integer, Integer>> pq = new PriorityQueue<PairBFS<Integer, Integer>>(Comparator.comparing(PairBFS::getKey));
        pq.add(new PairBFS(0, sourceNode));

        // Time for startingNode is 0
        signalReceivedAt[sourceNode] = 0;
        while (!pq.isEmpty()) {
            PairBFS<Integer, Integer> top = pq.poll();

            int curNode = top.value;
            int curNodeTime = top.key;

            if (curNodeTime > signalReceivedAt[curNode]) {
                continue;
            }

            if (!adjList.containsKey(curNode)) {
                continue;
            }

            // Broadcast signal to neighbor/adjacent nodes
            for (PairBFS<Integer, Integer> edge : adjList.get(curNode)) {
                int neighborNode = edge.value;
                int neighborNodeTime = edge.key;

                // Fastest signal time for neighbornode
                if (signalReceivedAt[neighborNode] > curNodeTime + neighborNodeTime) {
                    signalReceivedAt[neighborNode] = curNodeTime + neighborNodeTime;
                    pq.add(new PairBFS<Integer, Integer>(signalReceivedAt[neighborNode], neighborNode));
                }
            }
        }

    }

}
