// https://www.educative.io/courses/grokking-coding-interview-patterns-java/kth-smallest-number-in-m-sorted-lists
// approach uses min heap - read here https://www.educative.io/courses/grokking-coding-interview-patterns-java/introduction-to-k-way-merge

// Using a min heap
//
//1. Insert the first element of each list into a min heap. This sets up our starting point, with the heap helping us efficiently track the smallest current element among the lists.
//2. Remove the smallest element from the heap (which is always at the top) and add it to the output list. This ensures that our output list is being assembled in sorted order.
//3. Keep track of which list each element in the heap came from. This is for knowing where to find the next element to add to the heap.
//4. After removing the smallest element from the heap and adding it to the output list, replace it with the next element from the same list the removed element belonged to.
//5. Repeat steps 2–4 until all elements from all input lists have been merged into the output list.
// Time complexity: O(m log m) for loop1. O(k log m) for loop2. Total = O ((m+k) log m)
class Element {
    int value;
    int listIndex; // which list is the element from
    int index; // which index from the list
}
class FindSmallestNumber {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>((a, b) -> a.value - b.value);

        // iterate through all lists and populate heap with index 0 element from each list
        for (int i = 0 ; i < lists.size(); i++) {
            List<Integer> curList = lists.get(i);
            if (curList.size() == 0) {
                continue;
            }
            pq.offer(new Element(curList.get(0), i , 0));
        }

        // pop from heap and pick next element from list that the popped element came from
        int count = 0;
        int lastElement = 0;
        while (!pq.isEmpty()) {
            Element current = pq.poll();
            count++;
            lastElement = current.value;

            if (count == k) {
                return current.value;
            }

            if (current.index + 1 < lists.get(current.listIndex).size()) {
                pq.offer(new Element(lists.get(current.listIndex).get(current.index + 1), current.listIndex, current.index + 1));
            }

        }
        return lastElement;

    }
}