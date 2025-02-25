package de.olilo.euler;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EulerProblemsTest {
    @Test
    public void testAverageOf() throws Exception {
        final long start = 1L;
        final List<Long> timestamps = new ArrayList<>();
        timestamps.add(2L);
        timestamps.add(4L);

        final double expected = 1.5;
        final double actual = EulerProblems.averageOf(timestamps, start);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testTotalTime() throws Exception {
        final long start = 1L;
        final List<Long> timestamps = new ArrayList<>();
        timestamps.add(2L);
        timestamps.add(4L);

        final long expected = 3;
        final long actual = EulerProblems.totalTime(timestamps, start);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindLongestRuntime() throws Exception {
        final long start = 0;
        final Map<Integer, Long> timestamps = new LinkedHashMap<>();
        timestamps.put(1, 3L);
        timestamps.put(5, 10L);
        timestamps.put(8, 11L);

        final LongestDurationStatistic expected = new LongestDurationStatistic(7L, 5);
        final LongestDurationStatistic actual = EulerProblems.findLongestRuntime(timestamps, start);
        Assert.assertEquals(expected, actual);
    }
}
