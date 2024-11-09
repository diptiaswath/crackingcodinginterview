class SortColors {
    // https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-sort-colors
    public void sortColors(int[] colors) {
        int start = 0;
        int current = 0;
        int end = colors.length - 1;

        while (current <= end) {
            if (colors[current] == 0) {
                int temp = colors[current];
                colors[current] = colors[start];
                colors[start] = temp;
                current++;
                start++;
            } else if (colors[current] == 1) {
                current++;
            } else {
                int temp = colors[end];
                colors[end] = colors[current];
                colors[current] = temp;
                end--;
            }
        } // end-while
        return colors;
    }
}