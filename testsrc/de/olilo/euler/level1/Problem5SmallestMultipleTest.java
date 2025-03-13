package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class Problem5SmallestMultipleTest {

    @Test
    public void testFindSmallestMultipleUpTo() throws Exception {
        final BigInteger expected = BigInteger.valueOf(2520);
        final BigInteger actual = new Problem5SmallestMultiple().findSmallestMultipleUpTo(10);
        Assert.assertEquals(expected, actual);
    }

}
