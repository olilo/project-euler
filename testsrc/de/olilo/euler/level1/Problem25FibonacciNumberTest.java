package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem25FibonacciNumberTest {

    @Test
    public void testFibonacciIndexWithDigitCount() throws Exception {
        final int expected = 12;
        final int actual = new Problem25FibonacciNumber().fibonacciIndexWithDigitCount(3);
        Assert.assertEquals(expected, actual);
    }

}
