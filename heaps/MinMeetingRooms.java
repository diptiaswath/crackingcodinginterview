package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

// Use of Min Heap to store end times of the meetings
// https://leetcode.com/problems/meeting-rooms-ii/solution/
public class MinMeetingRooms {

    // Algorithm
    //
    //    1. Sort the given meetings by their start time.

    //    2. Initialize a new min-heap and add the first meeting's ending time to the heap.
    //      We simply need to keep track of the ending times as that tells us when a meeting room will get free.

    //    3. For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
    //    If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
    //    If not, then we allocate a new room and add it to the heap.

    //    4. After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.

    public int minMeetingRooms(int[][] intervals) {
        // sort the intervals by start of meeting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>((a,b) -> (a - b));
        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            //// if start time is after end time of current meeting on heap, then assign room to this meeting, since room is free
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

}
