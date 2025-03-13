package de.olilo.util;

import org.junit.Assert;
import org.junit.Test;

public class DivisorsTest {

    @Test
    public void testOf() throws Exception {
        final long[] expected = {1, 2, 4, 7, 14, 28};
        final long[] actual = Divisors.of(28);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOf100() throws Exception {
        final long[] expected = {1, 2, 4, 5, 10, 20, 25, 50, 100};
        final long[] actual = Divisors.of(100);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOfPrime() throws Exception {
        final long[] expected = {1, 7};
        final long[] actual = Divisors.of(7);
        Assert.assertArrayEquals(expected, actual);
    }

}
