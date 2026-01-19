package interview.preparation.company.interviews.design.time.series;

import interview.preparation.company.design.time.series.ITimeSeries;
import interview.preparation.company.design.time.series.TimeSeriesImpl;
import interview.preparation.company.design.time.series.model.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;

public class ITimeSeriesTest {
    static final long FIVE_MIN = 5 * 60 * 1000;
    private ITimeSeries its;

    @Before
    public void init()
    {
        its = new TimeSeriesImpl();
    }
    /**Java Streams – Keep FIRST event in every 5-minute window**/
    @Test
    public void dedupeKeepFirstTest()
    {
        long t0 = 0;

        List<Event> input = List.of(
            new Event("A", "x",t0),
            new Event("A", "y",t0 + 1_000),   // +1 sec
            new Event("A", "z",t0 + 2_000)    // +2 sec
        );

        List<Event> result = its.dedupeKeepFirst(input);

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(t0, result.get(0).time().longValue());
    }
    /**JJava Streams – Keep LATEST event within 5 minutes**/
    @Test
    public void dedupeKeepLatestTest()
    {
        long t0 = 0;

        List<Event> input = List.of(
            new Event("A","x", t0),
            new Event("A", "y",t0 + FIVE_MIN)
        );

        List<Event> result = its.dedupeKeepFirst(input);

        Assert.assertEquals(2, result.size());
    }

    @Test
    public void keepLastEventPer5MinWindowTest()
    {
        List<Event> input = List.of(
            new Event("A","x", ts("10:01")),
            new Event("A", "x",ts("10:03")),
            new Event("A", "x",ts("10:06")),
            new Event("A", "x",ts("10:09"))
        );

        List<Event> result = its.keepLastEventPer5MinWindow(input);

        Assert.assertEquals(2, result.size());
        Assert.assertEquals(ts("10:03"), result.get(0).time().longValue());
        Assert.assertEquals(ts("10:09"), result.get(1).time().longValue());
    }

    static long ts(String hhmm) {
        return LocalTime.parse(hhmm)
            .atDate(LocalDate.of(2025, 1, 1))
            .toInstant(ZoneOffset.UTC)
            .toEpochMilli();
    }
}
