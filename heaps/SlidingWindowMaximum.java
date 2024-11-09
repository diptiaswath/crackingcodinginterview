//You are given an array of integers nums, there is a sliding window of size k which is moving from the
// very left of the array to the very right. You can only see the k numbers in the window.
// Each time the sliding window moves right by one position.

// Return the max sliding window.

// https://leetcode.com/problems/sliding-window-maximum/description/

// SEE THE ALGO IN EDITORIAL. BEST EXPLANATION. O(N)
public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> dq = new ArrayDeque<>();
    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < k; i++) {
        while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
            dq.pollLast();
        }
        dq.offerLast(i);
    }
    res.add(nums[dq.peekFirst()]);

    for (int i = k; i < nums.length; i++) {
        if (dq.peekFirst() == i - k) {
            dq.pollFirst();
        }
        while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
            dq.pollLast();
        }

        dq.offerLast(i);
        res.add(nums[dq.peekFirst()]);
    }

    // Return the result as an array.
    return res.stream().mapToInt(i->i).toArray();
}