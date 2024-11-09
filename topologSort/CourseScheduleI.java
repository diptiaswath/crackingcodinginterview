// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you
// must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Modification of CourseScheduleII. If you have to study, do AlienDict first, then CourseScheduleII and then this one.
// https://leetcode.com/problems/course-schedule/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            Integer curVisitNode = queue.poll();
            nodesVisited++;
            for (Integer neighNode: adjList.get(curVisitNode)) {
                inCount.put(neighNode, inCount.get(neighNode) - 1);
                if (inCount.get(neighNode) == 0) {
                    queue.add(neighNode);
                }
            }
        }

        if (nodesVisited < numCourses) {
            return false;
        }

        return true;
    }
}