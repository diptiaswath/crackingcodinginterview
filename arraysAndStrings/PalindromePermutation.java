// Cracking the Coding Interview: Pg 195
// Given a string, write a function to check if it is a permutation of a palindrome
class PalindromePermutation {
    private int[] table;
    public boolean isPermutationOfPalindrome(String s) {
        this.table = buildCharacterFrequencyTable(s);
        return checkIfMaxOneOddCount();
    }

    // no more than 1 character can have an odd count
    private boolean checkIfMaxOneOddCount() {
        boolean flag = false;
        for (int i = 0 ; i < table.length; i++) {
            if (table[i] % 2 == 1) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }

    private int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (val >= a && val <= z) {
            return val - a;
        }
        return -1;
    }

    private void buildCharacterFrequencyTable(String s) {
        this.table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (int i = 0; i < s.length(); i++) {
            int x = getCharNumber(s.charAt(i));
            if (x != -1) {
                table[x]++; // table[x] = table[x] + 1
            }
        }
    }



    // Another approach: from https://www.educative.io/courses/grokking-coding-interview-patterns-java/palindrome-permutation
    public static boolean permutePalindrome(String st) {

        // Build a character frequency table
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < st.length(); i++) {
            countMap.put(st.charAt(i), countMap.getOrDefault(st.charAt(i), 0) + 1);
        }

        // TIP- TIP -TIP - Iterate through the frequencies. No more than one char should have an odd frequency count
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            Character c = entry.getKey();
            Integer freq = entry.getValue();
            if (freq % 2 == 1) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }
}