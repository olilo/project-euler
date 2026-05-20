package de.olilo.euler.level3;

import org.junit.Assert;
import org.junit.Test;

public class Problem53CombinatoricSelectionsTest {

    @Test
    public void testNoBinomialsExceedLimitForSmallN() {
        // For n <= 22 no binomial coefficient exceeds 1,000,000
        final int actual = new Problem53CombinatoricSelections().countBinomialsGreaterThanLimit(22, 1_000_000L);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testFirstBinomialExceedingMillion() {
        // C(23, 10) = 1,144,066 is the first binomial coefficient to exceed one million.
        // In row 23 the values C(23, 10), C(23, 11), C(23, 12), C(23, 13) all exceed the limit -> 4 values
        final int actual = new Problem53CombinatoricSelections().countBinomialsGreaterThanLimit(23, 1_000_000L);
        Assert.assertEquals(4, actual);
    }

    @Test
    public void testSmallLimit() {
        // C(4,2) = 6 is the only binomial > 5 for n <= 4
        final int actual = new Problem53CombinatoricSelections().countBinomialsGreaterThanLimit(4, 5L);
        Assert.assertEquals(1, actual);
    }

}
