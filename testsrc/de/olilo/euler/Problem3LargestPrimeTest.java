package de.olilo.euler;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oliver Lorenz
 * @since 0.0
 */
public class Problem3LargestPrimeTest {
    @Test
    public void testGetLargestPrimeOf13195() throws Exception {
        long expected = 29;
        long actual = new Problem3LargestPrime().getLargestPrimeOf(13195);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetLargestPrimeOfPrime() throws Exception {
        long expected = 29;
        long actual = new Problem3LargestPrime().getLargestPrimeOf(29);
        Assert.assertEquals(expected, actual);
    }
}
