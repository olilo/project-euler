package de.olilo.util;

import org.junit.Assert;
import org.junit.Test;

public class PrimeFactorsTest {
    @Test
    public void testOf() throws Exception {
        final int[] expected = new int[] {2, 2, 3, 5};
        final int[] actual = PrimeFactors.of(60);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOf28() throws Exception {
        final int[] expected = new int[] {2, 2, 7};
        final int[] actual = PrimeFactors.of(28);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOfPrime() throws Exception {
        final int[] expected = new int[] {11};
        final int[] actual = PrimeFactors.of(11);
        Assert.assertArrayEquals(expected, actual);
    }
}
