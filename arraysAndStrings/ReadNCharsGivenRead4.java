// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/268/
// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/269/
class ReadNCharsGivenRead4 {
    char[] bufInternal = new char[4];
    int bufPtr = 0;
    int bufSize = 0;

    /**
     * Reads up to n characters from the file and stores them in the buffer array buf.
     * @param buf Destination buffer (array of characters).
     * @param n Maximum number of characters to read.
     * @return The number of characters actually read.
     */
    public int read(char[] buf, int n) {
        int index = 0;

        while (index < n) {
            if (bufPtr == bufSize) {
                bufSize = read4(bufInternal);
                bufPtr = 0;
            }
            // if there are no more characters to read, break loop
            if (bufSize == 0) {
                break;
            }

            while (index < n && bufPtr < bufSize) {
                buf[index++] = bufInternal[bufPtr++];
            }
        }
        return index;

    }
}