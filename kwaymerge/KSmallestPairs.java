// https://www.educative.io/courses/grokking-coding-interview-patterns-java/find-k-pairs-with-smallest-sums
// Approach:
// 1. We start by pairing only the first element of the second list with each element of the first list. The sum of each pair and their respective indexes from the lists, i and j, are stored on a min-heap.

//2. Next, we use a second loop in which at each step, we do the following:
//We pop the pair with the smallest element from the min-heap and collect it in a result list.
//We make a new pair in which the first element is the first element from the pair we just popped and the second element is the next element in the second list.
//We push this pair along with its sum onto the min-heap.
//
//3. We keep a count of the steps and stop when the min-heap becomes empty or when we have found k pairs.

// Time complexity: O(m log m) for loop1. O(k log m) for loop2. Total = O ((m+k) log m)
class FindKPairs {
    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {
        // Output stores num at indexi in list1, num at indexj in list2
        List<List<Integer>> result = new ArrayList<>();
        // validations
        if (list1.length == 0 || list2.length == 0 || target == 0) {
            return result;
        }

        //  Min-heap to store pairs based on their sums
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0]-b[0]);


        // Populate min heap with sums of all elements in first list summed with element at index 0 of second list
        for (int i = 0; i < list1.length; i++) {
            pq.offer(new int[] {list1[i] + list2[0], i, 0});
        }

        // Extract k smallest pairs
        while (target-- > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            int sum = current[0];
            int list1Index = current[1];
            int list2Index = current[2];

            result.add(Arrays.asList(list1[list1Index], list2[list2Index]));

            if (list2Index + 1 < list2.length) {
                pq.add(new int[] {list1[list1Index] + list2[list2Index + 1], list1Index, list2Index + 1});
            }
        }
        return result;
    }
}