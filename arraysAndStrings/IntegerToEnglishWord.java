// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/273/
class IntegerToEnglishWord {
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three""Nineteen"}; // 1 - 19
    private static final String[] TENS = {"", "Ten", "Twenty", "Ninety"}; // 10, 20, 30, ..90
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};


    public static String getEnglishWord(int num) {
        int i = 0;
        String word = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                word = helper(num % 1000) + THOUSANDS[i] + " " + word;
            }
            num = num / 1000;
            i++;
        }
        return word.trim();
    }

    private static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) { // example 17
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) { // example 87
            return TENS[num] + " " + helper(num % 10);
        } else if (num > 100) {
            return LESS_THAN_20[num] + "Hundred" + helper(num%100);
        }
    }

}