// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
// course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return the ordering of courses you should take to finish all courses.
// If there are many valid answers, return any of them.
// If it is impossible to finish all courses, return an empty array.

// https://leetcode.com/problems/course-schedule-ii/description/
// O(V + E)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] orderedCourses = new int[numCourses];

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inCount = new HashMap<>();

        // Initialize adjList and inCount
        for (int i = 0; i< numCourses; i++) {
            adjList.put(i, new ArrayList<>());
            inCount.put(i, 0);
        }

        // Build adjList each pre-req: (src, dest) and dest -> src
        for (int[] preReq: prerequisites) {
            int dest = preReq[1];
            int src = preReq[0];
            inCount.put(src, inCount.get(src) + 1);
            adjList.get(dest).add(src);
        }

        // BFS but start with populating queue with nodes that have inCount = 0
        Queue<Integer> queue = new LinkedList<>();
        for (Integer node : inCount.keySet()) {
            if (inCount.get(node) == 0) {
                queue.add(node);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            orderedCourses[i++] = curNode;
            for (Integer neighNode: adjList.get(curNode)) {
                inCount.put(neighNode, inCount.get(neighNode) - 1);
                if (inCount.get(neighNode) == 0) {
                    queue.add(neighNode);
                }
            }
        }

        if (i < numCourses) {
            return new int[0];
        }

        return orderedCourses;
    }
}