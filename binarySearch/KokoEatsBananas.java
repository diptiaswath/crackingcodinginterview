// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
// If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//
//Return the minimum integer k such that she can eat all the bananas within h hours.

class Solution {
    // https://leetcode.com/problems/koko-eating-bananas/ - DID NOT USE THE LEETCODE SOLUTION, BUT READ THE EXPLANATION


    // This function finds the minimum eating speed k using binary search.
    // low is initialized to 1 (minimum possible eating speed), and high is initialized to the maximum number of bananas in any pile (Arrays.stream(piles).max().getAsInt()).
    // The while loop continues until low is less than high. In each iteration, the midpoint mid of the current range [low, high] is calculated.
    // The canFinish function is called with mid as the eating speed.
    //  If Koko can finish all the bananas at this speed within h hours, high is set to mid to try a smaller speed. Otherwise,
    //  low is set to mid + 1 to increase the speed.
    // The loop ends when low equals high, and the minimum eating speed k is returned.

    // Helper function to determine if Koko can finish with speed k in h hours
    private boolean canFinishWithinH(int[] piles, int k, int h) {
        int totalTime = 0;
        for (int pile: piles) {
            totalTime += Math.ceil((double) pile/k);
        }
        return totalTime <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left)/2;
            if (canFinishWithinH(piles, mid, h)) {
                right = mid; // try for an even smaller k than mid
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}