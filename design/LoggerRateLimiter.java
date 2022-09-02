package design;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/logger-rate-limiter/
public class LoggerRateLimiter {

    // record timestamp of when message is last printed
    private Map<String, Integer> messageTimestamp;

    public LoggerRateLimiter() {
        this.messageTimestamp = new HashMap<String, Integer>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamp.containsKey(message)) {
            messageTimestamp.put(message, timestamp);
            return true;
        }
        int lastTimestamp = messageTimestamp.get(message);

        if (timestamp - lastTimestamp >= 10) {
            // remember to update timestamp only if it is > (oldTimestamp + 10)
            messageTimestamp.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}
