package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem35CircularPrimesTest {

    @Test
    public void testIsCircularPrime() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem35CircularPrimes().isCircularPrime(197);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsCircularPrime887() throws Exception {
        final boolean expected = false;
        final boolean actual = new Problem35CircularPrimes().isCircularPrime(887);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCircularPrimesUntil() throws Exception {
        final int expected = 13;
        final int actual = new Problem35CircularPrimes().getCircularPrimesUntil(100).size();
        Assert.assertEquals(expected, actual);
    }

}
