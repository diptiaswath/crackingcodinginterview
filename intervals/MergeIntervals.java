// Use educative.io solution https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-merge-intervals
// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/310/
class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        // DO NOT FORGET!!
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> mergedIntervals = new LinkedList<int[]>();
        mergedIntervals.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            int curIntervalStart = curInterval[0];
            int curIntervalEnd = curInterval[1];

            int[] prevInterval = mergedIntervals.getLast();
            int prevIntervalEnd = prevInterval[1];

            if (curIntervalStart <= prevIntervalEnd) {
                prevInterval[1] = Math.max(curIntervalEnd, prevIntervalEnd);
            } else {
                mergedIntervals.add(new int[] {curIntervalStart, curIntervalEnd});
            }
        }

        return mergedIntervals.toArray(new int[][]{});
    }
}