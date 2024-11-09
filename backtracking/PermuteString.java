// O(n * n!)
// There are n! permutations of a string of length n
// swapChar() takes O(n)
class PermuteString {

    public static String swapChar(String word,int i, int j) {
        char[] swapIndex = word.toCharArray();
        char temp = swapIndex[i];
        swapIndex[i] = swapIndex[j];
        swapIndex[j] = temp;

        return new String(swapIndex);
    }

    public static  void permuteStringRec(String word, int currentIndex, ArrayList<String> results) {
        if(currentIndex == word.length() - 1) {
            results.add(word);
            return ;
        }
        for (int index = currentIndex; index < word.length(); index++) {
            // swaps character for each permutation
            String swappedStr = swapChar(word, currentIndex, index);

            // recursively calls itself to find each permutation
            permuteStringRec(swappedStr, currentIndex + 1, results);
        }
    }

    public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> results = new ArrayList<String>();
        permuteStringRec(word, 0, results);
        return results;
    }