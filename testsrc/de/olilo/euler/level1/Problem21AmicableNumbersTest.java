package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem21AmicableNumbersTest {

    @Test
    public void testAreAmicableNumbers() throws Exception {
        Assert.assertTrue(new Problem21AmicableNumbers().areAmicableNumbers(220, 284));
    }

    @Test
    public void testAreNotAmicableNumbers() throws Exception {
        Assert.assertFalse(new Problem21AmicableNumbers().areAmicableNumbers(219, 284));
    }

    @Test
    public void testSumOfAmicableNumbersUntil() throws Exception {
        final long expected = 504;
        final long actual = new Problem21AmicableNumbers().sumOfAmicableNumbersUntil(285);
        Assert.assertEquals(expected, actual);
    }

}
