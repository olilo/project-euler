package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem30DigitFifthPowersTest {

    @Test
    public void testGetDigitFifthPowers() throws Exception {
        final int expected = 32 + 32 + 1;
        final int actual = new Problem30DigitFifthPowers().getDigitFifthPowers(221);
        Assert.assertEquals(expected, actual);
    }

}
