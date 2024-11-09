//

class ScheduleTask {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);

    public static int tasks(List<List<Integer>> tasksList) {
        if (tasksList == null || tasksList.size() == 0) {
            return -1;
        }
        // Sort the tasks by their start time
        tasksList.sort((a, b) -> (a.get(0) - b.get(0))); // TIP - SEE THIS
        // if array, Arrays.sort(tasks, )

        // Use the min heap to track end time of the tasks
        for (List<Integer> task : tasksList) {
            int start = task.get(0);
            int end = task.get(1);

            // Check if any task has finished before the current task starts
            if (!minHeap.isEmpty() && minHeap.peek() <= start) {
                minHeap.poll();
            }

            // Schedule current task on available machine
            minHeap.offer(end);

        }


        return minHeap.size();
    }
}