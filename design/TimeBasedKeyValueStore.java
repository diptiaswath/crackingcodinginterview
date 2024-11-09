package design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/time-based-key-value-store/submissions/
// Design a time-based key-value data structure that can
// 1. store multiple values for the same key at different time stamps and
// 2. retrieve the key's value at a certain timestamp.
// 1. void set(String key, String value, int timestamp)
// ----> Stores the key key with the value value at the given time timestamp.
// 2. String get(String key, int timestamp)
// -----> Returns a value such that set was called previously, with timestamp_prev <= timestamp.
// -----> If there are multiple such values, it returns the value associated with the largest timestamp_prev.
// -----> If there are no values, it returns "".
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
