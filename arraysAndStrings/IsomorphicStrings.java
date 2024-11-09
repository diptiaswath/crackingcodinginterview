// https://www.educative.io/courses/grokking-coding-interview-patterns-java/isomorphic-strings
public class Main {
    public static boolean isIsomorphic(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        Map<Character, Character> s1s2 = new HashMap<>();
        Map<Character, Character> s2s1 = new HashMap<>();

        while (i < s1.length()) {
            char s1c = s1.charAt(i);
            char s2c = s2.charAt(j);

            if (s1s2.containsKey(s1c) && s1s2.get(s1c) != s2c) {
                return false;
            }

            if (s2s1.containsKey(s2c) && s2s1.get(s2c) != s1c) {
                return false;
            }
            s1s2.put(s1c, s2c);
            s2s1.put(s2c, s1c);
            i++;
            j++;
        }
        return true;
    }
}