// This is from Cracking Code Interview - Pg 199 but see DO NOT FORGET FOR ALL CASES
// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3015/
class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        // DONOTFORGET: If both strings are empty, they are not one edit distance apart
        if (s.length() == 0 && t.length() == 0) {
            return false;
        }

        // DONOTFORGET: If both strings are greater than 1 char apart, then they cannot be 1 edit apart
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() == t.length()) {
            return isOneReplace(s, t);
        } else if (s.length() + 1 == t.length()) {
            return isOneInsert(s, t);
        } else if (s.length() - 1 == t.length()) { //s is longer
            return isOneInsert(t, s); // DONOTFORGET: pass shorter string first
        }
        return false;
    }

    private boolean isOneReplace(String s, String t) {
        int i = 0; boolean flag = false;
        while (i<s.length()) {
            if (s.charAt(i) != t.charAt(i)) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
            i++;
        }
        return flag; // DONOTFORGET: must have found exactly one difference
    }

    private boolean isOneInsert(String first, String second) {
        int index1 = 0; int index2 = 0;
        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)){
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}