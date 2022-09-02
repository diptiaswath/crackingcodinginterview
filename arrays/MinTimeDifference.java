package arrays;

import java.util.List;

// https://leetcode.com/problems/minimum-time-difference/submissions/
public class MinTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        int mins_in_day = 24 * 60;
        int minDiff = Integer.MAX_VALUE;

        // add all timepoints to array
        boolean[] times = new boolean[mins_in_day];
        for(String t: timePoints) {
            int curr = Integer.parseInt(t.substring(0, 2)) * 60 + Integer.parseInt(t.substring(3));

            // if any time is duplicate, we can return 0.
            if(times[curr]) {
                return 0;
            }
            times[curr] = true;
        }

        // keep first time to compare from last
        int first = -1, prev = -1, curr = -1;
        for(int t = 0; t < mins_in_day; t++) {
            if(times[t]) {

                if (first == -1) {
                    first = t;
                }

                if (prev == -1) {
                    prev = t;
                    continue;
                }

                curr = t;
                minDiff = Math.min(minDiff, curr - prev);
                prev = curr;
            }
        }

        System.out.println("curr = " + curr + " , prev = " + prev + " , first = " + first);

        // compare time difference from last to first
        minDiff = Math.min(minDiff, mins_in_day - prev + first);
        return minDiff;

    }
}
