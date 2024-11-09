// https://leetcode.com/explore/interview/card/facebook/57/others-3/3043/
class IntersectIntervals {
    // https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-interval-list-intersections
    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
        List<int[]> intersections = new ArrayList<>();
        int i = 0, j = 0;

        while (i < intervalLista.length && j < intervalListb.length) {
            int start = Math.max(intervalLista[i][0], intervalListb[j][0]);
            int end = Math.min(intervalLista[i][1], intervalListb[j][1]);

            if (start <= end) {
                intersections.add(new int[]{start, end});
            }
            if (intervalLista[i][1] < intervalListb[j][1]) { // Increment the pointer (i or j) of the list having the smaller end time of the current interval.
                i += 1;
            } else {
                j += 1;
            }
        }

        // TIP: PAY ATTENTION TO THIS
        return intersections.toArray(new int[0][]);
    }

}