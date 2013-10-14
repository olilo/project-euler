package de.olilo.euler;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oliver Lorenz
 * @since 0.0
 */
public class AllProblemsTest {
    @Test
    public void testAverageOf() throws Exception {
        final long start = 1L;
        final List<Long> timestamps = new ArrayList<Long>();
        timestamps.add(2L);
        timestamps.add(3L);

        final double expected = 1.5;
        final double actual = AllProblems.averageOf(timestamps, start);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSum() throws Exception {
        final long start = 1L;
        final List<Long> timestamps = new ArrayList<Long>();
        timestamps.add(2L);
        timestamps.add(3L);

        final long expected = 3;
        final long actual = AllProblems.sum(timestamps, start);
        Assert.assertEquals(expected, actual);
    }
}
