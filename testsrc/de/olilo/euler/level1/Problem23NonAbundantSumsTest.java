package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem23NonAbundantSumsTest {

    @Test
    public void testIsAbundantNumber() throws Exception {
        final boolean actual = new Problem23NonAbundantSums().isAbundantNumber(12);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsAbundantNumber2() throws Exception {
        final boolean actual = new Problem23NonAbundantSums().isAbundantNumber(28);
        Assert.assertFalse("28 is considered abundant, although it is not", actual);
    }

    @Test
    public void testIsSumOfAbundantNumbers() throws Exception {
        final boolean actual = new Problem23NonAbundantSums().isSumOfAbundantNumbers(24);
        Assert.assertTrue("24 should be a sum of abundant numbers, but is considered not", actual);
    }

    @Test
    public void testIsSumOfAbundantNumbers2() throws Exception {
        final boolean actual = new Problem23NonAbundantSums().isSumOfAbundantNumbers(28);
        Assert.assertFalse("28 should not be a sum of abundant numbers", actual);
    }

    @Test
    public void testIsSumOfAbundantNumbers3() throws Exception {
        final boolean actual = new Problem23NonAbundantSums().isSumOfAbundantNumbers(103);
        Assert.assertFalse("103 should not be a sum of abundant numbers", actual);
    }

    @Test
    public void testSumOfNonAbundantSumsUntil() throws Exception {
        final int expected = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 + 15 + 16 + 17 + 18 + 19 + 20 +
                21 + 22 + 23 + 25;
        final int actual = new Problem23NonAbundantSums().sumOfNonAbundantSumsUntil(25);
        Assert.assertEquals(expected, actual);
    }
}