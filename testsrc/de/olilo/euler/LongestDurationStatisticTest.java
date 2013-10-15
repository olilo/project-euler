package de.olilo.euler;

import junit.framework.Assert;
import org.junit.Test;

public class LongestDurationStatisticTest {
    @Test
    public void testCheckAndUpdate() throws Exception {
        final LongestDurationStatistic statistic = new LongestDurationStatistic();
        statistic.checkAndUpdate(7L, 1);

        Assert.assertEquals(7L, statistic.duration);
        Assert.assertEquals(1, statistic.index);
    }

    @Test
    public void testGetDuration() throws Exception {
        final LongestDurationStatistic statistic = new LongestDurationStatistic(7L, 1);
        Assert.assertEquals(7L, statistic.getDuration());
    }

    @Test
    public void testGetIndex() throws Exception {
        final LongestDurationStatistic statistic = new LongestDurationStatistic(7L, 1);
        Assert.assertEquals(1, statistic.getIndex());
    }

    @Test
    public void testEquals() throws Exception {
        final LongestDurationStatistic statistic1 = new LongestDurationStatistic(7L, 1);
        final LongestDurationStatistic statistic2 = new LongestDurationStatistic(7L, 1);
        Assert.assertTrue(statistic1.equals(statistic2));
    }

    @Test
    public void testHashCode() throws Exception {
        final long hashcode1 = new LongestDurationStatistic(5L, 1).hashCode();
        final long hashcode2 = new LongestDurationStatistic(8L, 2).hashCode();
        Assert.assertTrue(hashcode1 != hashcode2);
    }
}
