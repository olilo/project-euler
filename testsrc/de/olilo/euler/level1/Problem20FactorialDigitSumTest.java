package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem20FactorialDigitSumTest {

    @Test
    public void testGetFactorialDigitSum() throws Exception {
        final int expected = 27;
        final int actual = new Problem20FactorialDigitSum().getFactorialDigitSum(10);
        Assert.assertEquals(expected, actual);
    }

}
