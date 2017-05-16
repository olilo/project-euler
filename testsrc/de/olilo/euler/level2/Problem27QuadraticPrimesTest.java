package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem27QuadraticPrimesTest {

    @Test
    public void testGetQuadraticPrimes() throws Exception {
        final int expected = 40;
        final int actual = new Problem27QuadraticPrimes().getQuadraticPrimes(1, 41).length;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetQuadraticPrimes2() throws Exception {
        final int expected = 80;
        final int actual = new Problem27QuadraticPrimes().getQuadraticPrimes(-79, 1601).length;
        Assert.assertEquals(expected, actual);
    }
}