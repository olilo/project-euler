package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem17NumberLetterCountsTest {
    @Test
    public void testCountLettersInNumberWordsFrom1To5() throws Exception {
        final long expected = 19;
        final long actual = new Problem17NumberLetterCounts().countLettersInNumberWordsFrom1To(5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountLettersInNumberWordsFrom1To10() throws Exception {
        final long expected = 39;
        final long actual = new Problem17NumberLetterCounts().countLettersInNumberWordsFrom1To(10);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetWordLengthOfNumber() throws Exception {
        final long expected = 37;
        final long actual = new Problem17NumberLetterCounts().getWordLengthOfNumber(52141);
        Assert.assertEquals(expected, actual);
    }
}
