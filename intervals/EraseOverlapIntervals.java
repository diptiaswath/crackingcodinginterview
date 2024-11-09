// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals
// you need to remove to make the rest of the intervals non-overlapping.
// https://leetcode.com/problems/non-overlapping-intervals/editorial/

// Sorting: The intervals are sorted based on their end times (intervals[i][1]). This ensures that we always try to keep the interval with the earliest end time, maximizing the number of non-overlapping intervals we can keep.
//Count Overlaps: The loop checks for overlaps. If an interval starts before the previous interval ends (intervals[i][0] < intervals[prev][1]), it means there is an overlap, so we increment the count.
//Update prev: If there is no overlap, we update prev to the current interval index i.
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prev = 0;
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <intervals[prev][1]) { // there is overlap
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }
}