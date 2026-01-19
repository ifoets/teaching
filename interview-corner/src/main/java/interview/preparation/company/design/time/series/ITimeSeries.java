package interview.preparation.company.design.time.series;


import interview.preparation.company.design.time.series.model.Event;

import java.util.List;

public interface ITimeSeries {

    /**How to process time-series data and remove entries repeating within 5 minutes for the same ID**/

    /**Java Streams – Keep FIRST event in every 5-minute window**/
    List<Event> dedupeKeepFirst(List<Event> entries);

    /**JJava Streams – Keep LATEST event within 5 minutes**/
    List<Event> dedupeKeepLatest(List<Event> entries);

    List<Event> keepLastEventPer5MinWindow(List<Event> events);
}
/*
1️⃣ Fixed Window Deduplication

Question
Given (id, value, timestamp), keep only one event per ID per fixed 10-minute window.

Follow-ups

Keep first vs keep last

How to handle out-of-order events?

2️⃣ Rolling Window Suppression

Question
Suppress events for the same ID if they occur within X minutes of the previous event.

Key concept

Debounce / suppression window

3️⃣ Status Change Detection

Question
From (id, status, timestamp), emit an event only when status changes.

UP → UP → DOWN  → DOWN → UP
        ↑             ↑

4️⃣ Gap Detection

Question
Detect when no event arrives for an ID for more than 15 minutes.

Used for

Heartbeat monitoring

SLA violations

5️⃣ Time-Based Aggregation

Question
Compute avg / min / max / p95 over 5-minute tumbling windows.

Follow-ups

Sliding vs tumbling

Memory optimization

6️⃣ Missing Data Filling

Question
Given per-minute metrics with missing timestamps, fill missing minutes using:

last known value

default value

7️⃣ Rate Calculation from Counters

Question
Given cumulative counters (id, count, timestamp), compute rate per second.

Trick

Counter resets

Negative deltas

8️⃣ Session Window Creation

Question
Group events into sessions, where a session ends after 30 minutes of inactivity.

Output

id, sessionStart, sessionEnd

9️⃣ Time-Series Downsampling

Question
Downsample:

1-second data → 1-minute average

1-minute → 1-hour max

Trade-offs

Accuracy vs storage

🔟 Time-Based Deduplication at Scale

Question
How do you deduplicate events within 5 minutes for millions of IDs?

Follow-ups

Memory constraints

Approximate solutions (Bloom filters)

Bonus (System Design flavor)

Design a real-time time-series processing pipeline with alerts and dashboards.
 */