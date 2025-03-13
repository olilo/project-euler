package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem44PentagonalNumbersTest {

    @Test
    public void testIsDifferenceAndSumPentagonalOf2167And1020() {
        final boolean expected = true;
        final boolean actual = new Problem44PentagonalNumbers().isDifferenceAndSumPentagonalOf(2167, 1020);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsDifferenceAndSumPentagonalOfFalse() {
        final boolean expected = false;
        final boolean actual = new Problem44PentagonalNumbers().isDifferenceAndSumPentagonalOf(4321, 1234);
        Assert.assertEquals(expected, actual);
    }

}
