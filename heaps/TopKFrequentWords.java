// https://www.educative.io/courses/grokking-coding-interview-patterns-java/top-k-frequent-words
public class FrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        // Build a word frequency map
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Create a min heap, buf if freq values are equal, use keys
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey().compareTo(a.getKey()); // Lexicographical order reversed for min-heap
            } else {
                return a.getValue() - b.getValue();
            }
        });

        // Add all frq map entries to min heap of size k
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        //
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }
        Collections.reverse(result);


        // Replace this placeholder return statement with your code
        return result;
    }


}