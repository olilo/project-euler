package de.olilo.euler.level1;

import junit.framework.Assert;
import org.junit.Test;

public class Problem6SumSquareDIfferenceTest {
    @Test
    public void testGetSumSquareDifference() throws Exception {
        final long expected = 2640;
        final long actual = new Problem6SumSquareDIfference().getSumSquareDifference(10);
        Assert.assertEquals(expected, actual);
    }
}
