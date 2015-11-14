package de.olilo.euler.level2;

import org.junit.Test;
import org.junit.Assert;

public class Problem28NumberSpiralDiagonalsTest {

    @Test
    public void testGetNumberSpiralDiagonalsFor5() throws Exception {
        final int expected = 101;
        final int actual = new Problem28NumberSpiralDiagonals().getNumberSpiralDiagonalsFor(5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberSpiralDiagonalsFor3() throws Exception {
        final int expected = 25;
        final int actual = new Problem28NumberSpiralDiagonals().getNumberSpiralDiagonalsFor(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberSpiralDiagonalsFor7() throws Exception {
        final int expected = 101 + 31 + 37 + 43 + 49;
        final int actual = new Problem28NumberSpiralDiagonals().getNumberSpiralDiagonalsFor(7);
        Assert.assertEquals(expected, actual);
    }
}