// https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-random-pick-with-weight
class RandomPickWithWeight {
    int totalRunSum = 0;
    int[] weights;
    int[] runSumWeights;

    // O(n)
    RandomPickWithWeight(int[] weights) {
        this.weights = weights;
        this.runSumWeights = new int[weights.length + 1];
        computeTotalRunSum();
    }

    public void computeTotalRunSum() {
        int runSum = 0;
        int i = 0;
        for (int weight: weights) {
            runSum += weight;
            runSumWeights[i++] = runSum;
        }
        this.totalRunSum = runSum;
    }

    // O(log n)
    public int pickIndex() {
        Random random = new Random();
        int pickElement = random.nextInt(totalRunSum) + 1;

        int start = 0;
        int end = runSumWeights.length;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (runSumWeights[mid] == pickElement) {
                return mid;
            } else if (pickElement < runSunWeights[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}


// TIP: same as RegularBinart search but see what is returned.