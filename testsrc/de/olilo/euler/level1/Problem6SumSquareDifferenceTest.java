package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem6SumSquareDifferenceTest {

    @Test
    public void testGetSumSquareDifference() throws Exception {
        final long expected = 2640;
        final long actual = new Problem6SumSquareDifference().getSumSquareDifference(10);
        Assert.assertEquals(expected, actual);
    }

}
