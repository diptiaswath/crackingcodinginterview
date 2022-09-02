package heaps;

import java.util.*;

// https://leetcode.com/problems/k-closest-points-to-origin/solution/

public class KClosestPointToOrigin {


    // my approach does not work when the euclidean distance is the same
    private int euclideanDistanceToOrigin(int[] point) {
        return (point[0] ^ 2 + point[1] ^ 2);
    }

    public int[][] kClosestTest(int[][] points, int k) {
        Set<Integer> distances = new TreeSet<Integer>();
        Map<Integer, Integer> distanceToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < points.length; i++) {
            int x = euclideanDistanceToOrigin(points[i]);
            System.out.println(x);
            distances.add(x);
            distanceToIndex.put(x, i);
        }


        int i = 0;
        int[][] ret = new int[k][];
        for (int distance: distances) {
            int index = distanceToIndex.get(distance);
            ret[i++] = new int[] { points[index][0], points[index][1]};
            if (i == k) {
                break;
            }
        }
        return ret;
    }



    // Time complexity : O(N log N)
    public int[][] kClosestApproach1(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> euclideanDistanceToOrigin(a) - euclideanDistanceToOrigin(b));
        return Arrays.copyOf(points, k);
    }


    // Use a max heap where point farthest from origin is at top of heap
    // Using priority queue: O (N log K), space complexity: O(K) since heap is max size of K
    public int[][] kClosest(int[][] points, int k) {

        // max heap, largest element at top. Farthest point from origin is at top of heap
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        for (int i = 0 ; i < points.length; i++) {
            int[] entry = new int[] {euclideanDistanceToOrigin(points[i]), i};
            if (heap.size() < k) {
                heap.add(entry);
            } else if (entry[0] < heap.peek()[0]) {
                // if heap size is at K elements, discard the farther point, and add closer one
                heap.poll();
                heap.add(entry);
            }
        }

        int[][] result = new int[points.length][2];
        for (int i = 0; i < k; i++) {
            int entryIndex = heap.poll()[1];
            result[i] = points[entryIndex];
        }
        return result;
    }


}
