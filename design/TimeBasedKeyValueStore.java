package design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/time-based-key-value-store/submissions/
public class TimeBasedKeyValueStore {

    private Map<String, TreeMap<Integer, String>> keyTimestampValues;

    public TimeBasedKeyValueStore() {
        this.keyTimestampValues = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyTimestampValues.containsKey(key)) {
            keyTimestampValues.put(key, new TreeMap<Integer, String>());
        }
        TreeMap<Integer, String> timestampValues = keyTimestampValues.get(key);
        timestampValues.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!keyTimestampValues.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> timestampValues = keyTimestampValues.get(key);

        // Returns the greatest key less than or equal to input timestamp.
        Integer ts = timestampValues.floorKey(timestamp);

        System.out.println("Floor key for timestamp = " + timestamp + ", is = " + ts);
        if (ts == null) {
            return "";
        }
        return timestampValues.get(ts);
    }
}
