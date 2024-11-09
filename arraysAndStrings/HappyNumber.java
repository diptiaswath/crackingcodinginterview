class HappyNumber {
    // https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-happy-number
    private int sumOfSquaredDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, 2);
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappyNumber(int n) {
        int slowPointer = n;
        int fastPointer = sumOfSquaredDigits(n);

        while (fastPointer != 1 && slowPointer != fastPointer) {
            slowPointer = sumOfSquaredDigits(slowPointer);
            fastPointer = sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
        }
        return fastPointer == 1;
    }

}