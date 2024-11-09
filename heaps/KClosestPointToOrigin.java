package heaps;

import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distToOrigin() {
        return (x * x) + (y * y);
    }
}

// https://www.educative.io/courses/grokking-coding-interview-patterns-java/k-closest-points-to-origin

public class KClosestPointToOrigin {

    public  List<Point> kClosest(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(
                (p1, p2) -> (p2.distToOrigin() - p1.distToOrigin()));

        for (Point p: points) {
            maxHeap.add(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<Point>(maxHeap);
    }

    // if signature of method is different
    public int[][] kClosest(int[][] points, int k) {
        Point[] pointsNew = new Point[points.length];

        // Translate int[][] points to Point[]
        int i = 0;
        for (int[] point: points) {
            pointsNew[i++] = new Point(point[0], point[1]);
        }

        // same as before
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(
                (p1, p2) -> (p2.distToOrigin() - p1.distToOrigin()));

        for (Point p: pointsNew) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // return as int[][] and not as List<Point>
        int[][] result = new int[maxHeap.size()][2];
        i = 0;
        while(!maxHeap.isEmpty()) {
            Point p = maxHeap.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
            i++;
        }
        return result;
    }





}
