package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem50ConsecutivePrimeSumTest {

    @Test
    public void testFindPrimeAddingToLongestPrimeSequenceBelow100() {
        final int expected = 41;
        final int actual = new Problem50ConsecutivePrimeSum().findPrimeAddingToLongestPrimeSequenceBelow(100);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindPrimeAddingToLongestPrimeSequenceBelow1000() {
        final int expected = 953;
        final int actual = new Problem50ConsecutivePrimeSum().findPrimeAddingToLongestPrimeSequenceBelow(1000);
        Assert.assertEquals(expected, actual);
    }

}
