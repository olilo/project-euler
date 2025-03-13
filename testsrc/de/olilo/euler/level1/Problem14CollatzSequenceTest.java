package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem14CollatzSequenceTest {

    @Test
    public void testFindLongestSequenceUnder() {
        final int expected = 9;
        final int actual = new Problem14CollatzSequence().findLongestSequenceUnder(14);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCollatzLength() {
        final int expected = 20;
        final int actual = new Problem14CollatzSequence().getCollatzLength( 9);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNextCollatzNumberOdd() {
        final long expected = 40;
        final long actual = new Problem14CollatzSequence().getNextCollatzNumber(13);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNextCollatzNumberEven() {
        final long expected = 20;
        final long actual = new Problem14CollatzSequence().getNextCollatzNumber(40);
        Assert.assertEquals(expected, actual);
    }

}
