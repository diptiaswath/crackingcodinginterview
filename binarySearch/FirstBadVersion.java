class FirstBadVersion {
    // https://leetcode.com/problems/first-bad-version/
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int calls = 0;
        while (left <= right) { // both when left <= right, you have to use right = mid - 1
            int mid = (left + (right - left)/2);
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            // if you need to keep track of the # times isBadVersion is called. problem defined here:
            // https://www.educative.io/courses/grokking-coding-interview-patterns-java/first-bad-version
            calls++;
        }
        return left;
        // return new int[] {left, calls};
    }

}

// TIP: Same as Regular Binary Search but see what is returned