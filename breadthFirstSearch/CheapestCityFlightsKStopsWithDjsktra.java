package breadthFirstSearch;

// Djkstra's algorithm uses a min-heap priority queue to pick a node that can
// be reached in the shortest amount of time/cost/weight from current start point
// that starts all the way from the source. But we need to keep track of # of stops taken to reach a node
// MinHeap (NODE, DISTANCE, #STOPS)

// https://leetcode.com/problems/cheapest-flights-within-k-stops/solution/

import java.util.*;

// Algorithm:
// 1. Init a min heap or a pq
// 2. distance[] = shortest distance of each node from soure
//    stops[] = shortest # of stop from source



//We iterate over all of C's neighbors which we can obtain from our adjacency matrix.
// For each neighbor, we check if the value dC +W(C, V) is less than dV.
// where V represents the neighbor node,
// dC and dV represent the shortest distances of these nodes
// W (C, V) represents the weight (cost of the flight) from node (city) C to V.
//
//If this is not the case then we check if number of stops for node C + 1 is lower than the number of stops for the node V
// (from the other dictionary). If that is the case, then it means there is a path from the source to the node V
// which is slightly expensive than what we have right now, but it has lesser stops and hence, it should be considered.
public class CheapestCityFlightsKStopsWithDjsktra {


    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int K) {

        int[][] adjMatrix = new int[n][n];
        // Build adjacency matrix
        for (int[] flight : flights) {
            int sourceCity = flight[0];
            int destCity = flight[1];
            int distance = flight[2];

            adjMatrix[sourceCity][destCity] = distance;
        }

        // Init the distance and stops
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MIN_VALUE);

        distance[src] = 0;
        stops[src] = 0;

        // Init min heap as a PQ int[] {node, distance, stops}
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {src, 0, 0});

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int node = info[0];
            int nodeDist = info[1];
            int nodeStop = info[2];

            // if dest is reached, return nodeDist to reach dest
            if (node == dest) {
                return nodeDist;
            }

            // if there are no more stops left, continue past this node
            if (nodeStop == K + 1) {
                continue;
            }

            // Look at all neighborNodes
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (adjMatrix[node][neighbor] > 0) {
                    int dU = nodeDist;
                    int dV = distance[neighbor];
                    int wUV = adjMatrix[node][neighbor];

                    if (dU + wUV < dV) {
                        pq.offer(new int[]{neighbor, dU + wUV, nodeStop + 1});
                        distance[neighbor] = dU + wUV;
                        stops[neighbor] = nodeStop;
                    } else if (nodeStop < stops[neighbor]) {
                        pq.offer(new int[]{neighbor, dU + wUV, nodeStop + 1});
                    }
                }
            }
        }


        return distance[dest] == Integer.MAX_VALUE? -1 : distance[dest];
    }
}
