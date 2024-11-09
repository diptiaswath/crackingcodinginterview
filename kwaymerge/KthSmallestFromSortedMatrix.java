public static int kthSmallest(int[][] matrix, int k) {
    int rowCount = matrix.length;
    // Min-heap to store elements with their coordinates (value, row, col)
    PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

    // Initialize the heap with the first element of each row
    for (int i = 0; i < Math.min(rowCount, k); i++) {
        minHeap.offer(new Element(matrix[i][0], i, 0));
    }

    // Pop elements from the heap and track the count
    int count = 0;
    int result = 0;

    while (!minHeap.isEmpty()) {
        Element current = minHeap.poll();
        result = current.value;
        count++;

        // If k elements have been removed, return the last popped element
        if (count == k) {
            return result;
        }

        // If the current element has a next element in the same row, push it to the heap
        if (current.col + 1 < matrix[current.row].length) {
            minHeap.offer(new Element(matrix[current.row][current.col + 1], current.row, current.col + 1));
        }
    }

    return result;  // This line is never reached if k is valid
}

static class Element {
    int value;
    int row;
    int col;

    Element(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }
}