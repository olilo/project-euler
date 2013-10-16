package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem7NthPrimeTest {
    @Test
    public void testGetNthPrime() throws Exception {
        final int expected = 13;
        final int actual = new Problem7NthPrime().getNthPrime(6);
        Assert.assertEquals(expected, actual);
    }
}
