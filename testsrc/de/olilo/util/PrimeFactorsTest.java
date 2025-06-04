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

    @Test
    public void testCountDistinctTwoPrimeFactors() {
        final int expected = 2;
        final int actual = PrimeFactors.countDistinct(14);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountDistinctThreePrimeFactors() {
        final int expected = 3;
        final int actual = PrimeFactors.countDistinct(645);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountDistinctFourPrimeFactors() {
        final int expected = 4;
        final int actual = PrimeFactors.countDistinct(714);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountDistinctPrime() {
        final int expected = 1;
        final int actual = PrimeFactors.countDistinct(25_083_391);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountDistinctZero() {
        final int expected = 0;
        final int actual = PrimeFactors.countDistinct(0);
        Assert.assertEquals(expected, actual);
    }

}
