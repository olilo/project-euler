package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem34DigitFactorialsTest {

    @Test
    public void testIsDigitFactorial145() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem34DigitFactorials().isDigitFactorial(145);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsDigitFactorial143() throws Exception {
        final boolean expected = false;
        final boolean actual = new Problem34DigitFactorials().isDigitFactorial(143);
        Assert.assertEquals(expected, actual);
    }

}