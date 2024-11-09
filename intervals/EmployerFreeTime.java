// You’re given a list containing the schedules of multiple employees.
// Each person’s schedule is a list of non-overlapping intervals in a sorted order.
// An interval is specified with the start and end time, both being positive integers.
// Your task is to find the list of finite intervals representing the free time for all the employees.

//  https://www.educative.io/courses/grokking-coding-interview-patterns-java/employee-free-time
class Solution {
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a,b)-> (a.start - b.start));

        // O(n log n)
        for (List<Interval> intervals: schedule) {
            pq.addAll(intervals);
        }

        // process heap O(m log n) m = no of emp intervals, n = no of employees
        Interval prev = pq.poll();
        while (!pq.isEmpty()) {
            Interval current = pq.poll();
            if (current.start <= prev.end) {
                prev.end = Math.max(prev.end, current.end);
            } else {
                result.add(new Interval(prev.end, current.start)); // NOTE: TIP:  THIS FREE TIME
                prev = current;
            }
        }


        return result;
    }
}

//TIP: Use the solution you came up with from algo details on page 1 and not educative.io's provided one on page 2