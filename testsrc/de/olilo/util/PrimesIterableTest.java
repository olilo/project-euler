package de.olilo.util;

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

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove() throws Exception {
        final Iterator<Integer> iter = PrimesIterable.INSTANCE.iterator();
        iter.next();
        iter.remove();
    }

    @Test
    public void testIteratorPreload() throws Exception {
        final long startTime = System.currentTimeMillis();
        for (int prime : PrimesIterable.INSTANCE) {
            if (prime >= 104743) {
                Assert.assertEquals(104743, prime);
                break;
            }
        }
        final long duration = System.currentTimeMillis() - startTime;
        System.out.println("Needed " + duration + "ms to preload the primes");
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
    public void testIsPrimeInternal() throws Exception {
        Assert.assertTrue(PrimesIterable.INSTANCE.isPrimeInternal(11L));
    }

    @Test
    public void testIsPrime() throws Exception {
        Assert.assertTrue(PrimesIterable.INSTANCE.isPrime(971));
    }

    @Test
    public void testIsPrimeLong() throws Exception {
        Assert.assertTrue(PrimesIterable.INSTANCE.isPrime( 7_427_466_391L));
    }

    @Test
    public void testIsPrimeFalse() throws Exception {
        Assert.assertFalse(PrimesIterable.INSTANCE.isPrime(973));
    }

    @Test
    public void testConcurrency() throws Exception {
        final Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i : PrimesIterable.INSTANCE) {
                    if (i > 1000000) {
                        break;
                    }
                }
            }
        };
        final Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i : PrimesIterable.INSTANCE) {
                    if (i > 1000000) {
                        break;
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}
