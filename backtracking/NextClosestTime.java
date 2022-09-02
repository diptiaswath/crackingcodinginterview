package backtracking;

import java.util.*;

// https://leetcode.com/explore/interview/card/google/59/array-and-strings/471/
public class NextClosestTime {


    public String nextClosestTime(String time) {
        Set<Integer> intTime = new HashSet<>();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            if (Character.isDigit(c)) {
                intTime.add(c - '0');
            }
        }
        System.out.println(intTime);

        // generate all permutations of intTime in allTimes
        List<String> allTimes = new ArrayList<>();
        permute(0, intTime, allTimes, new StringBuilder());

        // sort allTimes
        allTimes.sort(Comparator.comparingInt(s -> parse(s)));
        int index = 0;
        for (int i = 0; i < allTimes.size(); i++) {
            System.out.println(allTimes.get(i));
            if (time.equals(allTimes.get(i))) {
                index = i;
            }
        }

        if (index + 1 < allTimes.size()) {
            return allTimes.get(index + 1);
        } else {
            return allTimes.get(0);
        }
    }

    private void permute(int cur, Set<Integer> intTime, List<String> allTimes, StringBuilder sb) {
        if (cur >= 60 || sb.length() == 2 && cur >= 24) {
            return;
        }
        if (sb.length() == 5) {
            allTimes.add(sb.toString());
            return;
        }
        if (sb.length() == 2) {
            sb.append(":");
            cur = 0;
        }
        int sz = sb.length();
        for (int digit : intTime) {
            sb.append(digit);
            permute(10 * cur + digit, intTime, allTimes, sb);
            sb.setLength(sz);
        }
    }

    private int parse(String s) {
        return Integer.parseInt(s.substring(0,2)) * 60 + Integer.parseInt(s.substring(3));
    }

}
