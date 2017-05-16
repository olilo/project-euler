package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem14CollatzSequenceTest {
    @Test
    public void testFindLongestSequenceUnder() throws Exception {
        final int expected = 9;
        final int actual = new Problem14CollatzSequence().findLongestSequenceUnder(14);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCollatzLength() throws Exception {
        final int expected = 20;
        final int actual = new Problem14CollatzSequence().getCollatzLength(new int[10], 9);
        Assert.assertEquals(expected, actual);
    }
}
