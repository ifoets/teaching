package com.system.design.core.algo.scalability.distrubuted;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FixedWindowRateLimiter {
    private static final Map<String, FixedWindow> hashMap = new HashMap<>();
    // how many request you are going allow
    private static final int THRESHOLD = 3;
    // this is the period, if it is 1 it means you are gonna allow 3 request in 1 second
    private static final int PERIOD_IN_SECONDS = 1;

    static class FixedWindow {
        public int count;
        public long timestamp;

        public FixedWindow(int count, long timestamp) {
            this.count = count;
            this.timestamp = timestamp;
        }
    }

    public boolean request(String userId) {
        // this method returns true or false.
        // If we have exceeded the limit, it will return false signifying the request was dropped.
        // otherwise true
        FixedWindow fixedWindow = hashMap.get(userId);
        long currentTime = System.currentTimeMillis();
        if (fixedWindow == null || currentTime - fixedWindow.timestamp > PERIOD_IN_SECONDS * 1000L) {
            hashMap.put(userId, new FixedWindow(1, currentTime));
            return true;
        } else {
            // check if we have breached the count already
            if (fixedWindow.count < THRESHOLD) {
                fixedWindow.count += 1;
                hashMap.put(userId, fixedWindow);
                return true;
            } else {
                return false;
            }
        }
    }
}
