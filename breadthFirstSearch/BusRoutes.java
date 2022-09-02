package breadthFirstSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://www.youtube.com/watch?v=neHZ_2ioxl0 - best explanation
// https://leetcode.com/problems/bus-routes/submissions/
public class BusRoutes {

    // Algo:
    // 1. Edge case
    // 2. Make an adjacency list/map where key is the bus stop, and a set of buses that have this bus stop
    // 3. BFS - add the source bus stop
    // 4. Count how many buses we have to go on
    // 5. For each bus stop, get the buses to go on
    // 6. check if we have been on this bus before
    // 7. for every stop on this bus, check if it is the target stop. if not, add the bus stop to the queue
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        // key = bus stop, hashset of bus number
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                HashSet<Integer> busRoutes = hm.containsKey(routes[i][j]) ? hm.get(routes[i][j]) : new HashSet<>();
                busRoutes.add(i);
                hm.put(routes[i][j], busRoutes);
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(source);
        int count = 0;// count how many buses we have to go on
        HashSet<Integer> seen = new HashSet<>();
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                //System.out.println(" i = " + i + " size = " + size);
                int curStop = q.poll();

                HashSet<Integer> buses = hm.get(curStop);
                for (Integer bus : buses) {
                    if (seen.add(bus)) {
                        for (Integer stop : routes[bus]) {
                            if (stop == target) {
                                return count;
                            }
                            q.add(stop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
