import java.util.*;
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-insert-interval
class Solution {
    // Given a sorted list of nonoverlapping intervals and a new interval,
    // your task is to insert the new interval into the correct position while
    // ensuring that the resulting list of intervals remains sorted and nonoverlapping.
    // Each interval is a pair of nonnegative numbers, the first being the start time and the
    // second being the end time of the interval.



    // Approach:
    // Since the intervals are sorted, we'll create an empty list, output, and start adding the intervals that start before the new interval.

    // Next, we'll add the new interval to the output list and merge it with the previously added interval if there is an overlap.

    // Finally, we'll add the remaining intervals to the output list, merging them with the previously added intervals when they overlap.
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;
        int n = existingIntervals.length;
        LinkedList<int[]> outputList = new LinkedList<>();
        while (i < n && existingIntervals[i][0] < newStart) {
            outputList.add(existingIntervals[i]);
            i += 1;
        }
        if (outputList.size() > 0 && newInterval[0] <= outputList.getLast()[1]) {
            outputList.getLast()[1] = Math.max(newInterval[1], outputList.getLast()[1]);
        } else {
            outputList.add(newInterval);
        }

        while (i < n) {
            int[] ei = existingIntervals[i];
            int start = ei[0];
            int end = ei[1];

            if (start <= outputList.getLast()[1]) {
                outputList.getLast()[1] = Math.max(end, outputList.getLast()[1]);
            } else {
                outputList.add(ei);
            }
            i += 1;
        }
        return outputList.toArray(new int[][]{});
    }
}