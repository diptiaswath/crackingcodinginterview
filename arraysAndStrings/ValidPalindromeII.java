public class ValidPalindromII {
    // Use Leetcode approach: https://leetcode.com/problems/valid-palindrome-ii/
    private static boolean checkIfPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return checkIfPalindrome(s, left + 1, right) ||
                        checkIfPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
}