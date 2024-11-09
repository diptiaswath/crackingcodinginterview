//
// O(n^3)
public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
        return "";
    }
    System.out.println(s.length());
    for (int length = s.length(); length > 0; length--) {
        for (int start = 0; start <= s.length() - length; start++) { // TIP: Technique overlaps with PermuteS2InS1
            int end = start + length - 1;
            System.out.println("Checking substring from index " + start + " to " + end);
            if (check(start, end, s)) {
                return s.substring(start, end + 1);
            }
        }
    }

    return "";
}

private boolean check(int i, int j, String s) {
    int left = i;
    int right = j;

    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }

    return true;
}