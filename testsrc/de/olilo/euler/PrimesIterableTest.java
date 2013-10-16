package de.olilo.euler;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * Test for PrimesIterable.
 */
public class PrimesIterableTest {
    @Test
    public void testIterator() throws Exception {
        final Iterator<Integer> iter = PrimesIterable.INSTANCE.iterator();
        int expected = 2;
        int actual = iter.next();
        Assert.assertEquals(expected, actual);

        final Iterator<Integer> iter2 = PrimesIterable.INSTANCE.iterator();
        actual = iter2.next();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIteratorPreload() throws Exception {
        for (int prime : PrimesIterable.INSTANCE) {
            if (prime >= 104743) {
                Assert.assertEquals(104743, prime);
                break;
            }
        }
    }

    @Test
    public void testPreloadNextPrimes() throws Exception {
        int before = PrimesIterable.INSTANCE.countCachedPrimes();
        PrimesIterable.INSTANCE.preloadNextPrimes();

        int expected = before + 4;
        int actual = PrimesIterable.INSTANCE.countCachedPrimes();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPrime() throws Exception {
        Assert.assertTrue(PrimesIterable.INSTANCE.isPrime(11));
    }
}
