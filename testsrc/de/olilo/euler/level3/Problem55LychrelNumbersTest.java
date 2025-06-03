package de.olilo.euler.level3;

import org.junit.Assert;
import org.junit.Test;

public class Problem55LychrelNumbersTest {

    @Test
    public void testCountLychrelNumbersBelow197() {
        final int expected = 1;
        final int actual = new Problem55LychrelNumbers().countLychrelNumbersBelow(200);
        Assert.assertEquals(expected, actual);
    }

}
