// https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-reverse-words-in-a-string
class ReverseWordsInString {
    // A function that reverses characters from startRev to endRev in place
    private static void strRev(char[] str, int startRev, int endRev) {
        while (startRev < endRev) {
            char temp = str[startRev];
            str[startRev] = str[endRev];
            str[endRev] = temp;
            startRev++;
            endRev--;
        }
    }

    public static String reverseWords(String sentence) {
        // \\s+ is a regular expression pattern that matches one or more whitespace characters (spaces, tabs, newlines, etc.).
        //" " is the replacement string, which in this case is a single space. So, any sequence of one or more whitespace characters will be replaced with a single space.
        sentence = sentence.replaceAll("\\s+", " ").trim();

        char[] charArray = sentence.toCharArray();
        int strLen = charArray.length - 1;

        strRev(charArray, 0, strLen);

        int start = 0;
        for (int end = 0; end <= strLen; ++end) {
            if (end == strLen || charArray[end] == ' ') {
                int endIdx = (end == strLen ) ? end : end - 1;
                strRev(charArray, start, endIdx);
                start = end + 1;
            }
        }

        return new String(charArray);
    }

}