package arrays;

// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
// https://leetcode.com/problems/implement-strstr/
public class StrStr {

    public int strStr(String haystack, String needle) {
        int isFound = haystack.indexOf(needle);
        return isFound;
    }
}

