package de.olilo.euler;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oliver Lorenz
 * @since 0.0
 */
public class Problem3LargestPrimeTest {
    @Test
    public void testGetLargestPrimeOf() throws Exception {
        int expected = 29;
        int actual = new Problem3LargestPrime().getLargestPrimeOf(13195);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindNextPrime() throws Exception {
        final List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        int expected = 11;
        int actual = new Problem3LargestPrime().findNextPrime(7, primes);
        Assert.assertEquals(expected, actual);
    }
}
