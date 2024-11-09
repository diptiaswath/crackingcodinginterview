


        Store each character and its frequency in a HashMap.
        Construct a max-heap using a PriorityQueue.
        Iterate over the heap, pop the most frequent character, append it to the result string, and manage the frequency.
        Use a wait queue to ensure once a character is used, you are not using it for the next iteration itself. Helps prevent adjacent duplicate characters.
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-reorganize-string
public class CharacterFrequency {

    public static String rearrangeString(String s) {
        // Step 1: Store each character and its frequency in a HashMap
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Construct a max-heap using the character frequency data
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(frequencyMap.entrySet());

        // Step 3: Iterate over the heap to build the result string
        StringBuilder result = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            result.append(current.getKey());
            current.setValue(current.getValue() - 1);

            // Add the current character to the wait queue
            waitQueue.add(current);

            // Ensure the characters in wait queue are ready to be re-added to the heap
            if (waitQueue.size() >= 2) {
                Map.Entry<Character, Integer> front = waitQueue.poll();
                if (front.getValue() > 0) {
                    maxHeap.add(front);
                }
            }
        } // end-while

        return result.length() == s.length() ? result.toString() : "";
    }
}

