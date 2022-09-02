package arrays;

import java.util.*;

// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
public class AlertMoreThanThreeInHour {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        for (int i = 0; i < keyTime.length; i++) {
            String name = keyName[i];
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
            }
            String time = keyTime[i];
            Integer mins = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
            map.get(name).add(mins);
        }

        HashSet<String> names = new HashSet<>();
        for (String name: map.keySet()) {
            List<Integer> times = map.get(name);
            Collections.sort(times);
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i-2) <= 60) {
                    names.add(name);
                }
            }
        }

        List<String> resultNames = new ArrayList<>(names);
        Collections.sort(resultNames);
        return resultNames;
    }
}
