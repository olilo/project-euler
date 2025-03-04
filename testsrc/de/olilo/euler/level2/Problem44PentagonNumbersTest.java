package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem44PentagonNumbersTest {

    @Test
    public void testGetPentagonalNumber() {
        final int expected = 22;
        final int actual = new Problem44PentagonNumbers().getPentagonalNumber(4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPentagonalNumber2() {
        final int expected = 70;
        final int actual = new Problem44PentagonNumbers().getPentagonalNumber(7);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPentagonalNumber() {
        final boolean expected = true;
        final boolean actual = new Problem44PentagonNumbers().isPentagonalNumber(92);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPentagonalNumberBigNumber() {
        final boolean expected = true;
        final boolean actual = new Problem44PentagonNumbers().isPentagonalNumber(3290);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPentagonalNumberFalse() {
        final boolean expected = false;
        final boolean actual = new Problem44PentagonNumbers().isPentagonalNumber(95);
        Assert.assertEquals(expected, actual);
    }
}
