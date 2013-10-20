package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem16PowerDigitSumTest {
    @Test
    public void testDigitSumOfTwoToThePowerOf() throws Exception {
        final long expected = 26;
        final long actual = new Problem16PowerDigitSum().digitSumOfTwoToThePowerOf(15);
        Assert.assertEquals(expected, actual);
    }
}
