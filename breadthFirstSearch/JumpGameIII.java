// Given an array of non-negative integers arr, you are initially positioned at start index of the array.
// When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
// Notice that you can not jump outside of the array at any time.
// https://leetcode.com/problems/jump-game-iii/description/
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            // check if reach zero
            if (arr[node] == 0) {
                return true;
            }
            if (arr[node] < 0) {
                continue;
            }

            // check available next steps
            if (node + arr[node] < n) {
                q.offer(node + arr[node]);
            }
            if (node - arr[node] >= 0) {
                q.offer(node - arr[node]);
            }
            // mark as visited
            arr[node] = -arr[node];
        }
        return false;
    }
}