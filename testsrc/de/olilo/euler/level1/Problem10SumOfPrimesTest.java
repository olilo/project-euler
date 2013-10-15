package de.olilo.euler.level1;

import junit.framework.Assert;
import org.junit.Test;

public class Problem10SumOfPrimesTest {
    @Test
    public void testSumOfPrimesUpTo() throws Exception {
        final long expected = 17;
        final long actual = new Problem10SumOfPrimes().sumOfPrimesUpTo(10);
        Assert.assertEquals(expected, actual);
    }
}
