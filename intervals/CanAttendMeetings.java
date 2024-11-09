// Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
// https://leetcode.com/problems/meeting-rooms/description/
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // if there are no intervals, then return true
        if (intervals.length == 0) {
            return true;
        }
        // Sort all intervals based on their start time O(N log N)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));


        for (int i =0; i < intervals.length - 1; i++) { // O(N)
            if (intervals[i+1][0] < intervals[i][1]) { // if start time of next interval is less than prev end time, they overlap
                return false;
            }
        }
        return true;

    }
}