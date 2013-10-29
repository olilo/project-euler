package de.olilo.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DivisorsTest {
    @Test
    public void testOf() throws Exception {
        final long[] expected = {1, 2, 4, 7, 14, 28};
        final long[] actual = Divisors.of(28);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOfPrime() throws Exception {
        final long[] expected = {1, 7};
        final long[] actual = Divisors.of(7);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetUniqueDivisorsFromPrimeFactors() throws Exception {
        final Set<Long> expected = new HashSet<Long>();
        expected.add(1L);
        expected.add(2L);
        expected.add(4L);
        expected.add(7L);
        expected.add(14L);
        expected.add(28L);
        final Set<Long> actual = Divisors.getUniqueDivisorsFromPrimeFactors(PrimeFactors.of(28));
        Assert.assertEquals(expected, actual);
    }
}
