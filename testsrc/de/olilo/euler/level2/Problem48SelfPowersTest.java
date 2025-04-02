package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class Problem48SelfPowersTest {

    @Test
    public void testGetExponentSeriesSum() {
        BigInteger expected = BigInteger.valueOf(10405071317L);
        BigInteger actual = new Problem48SelfPowers().getExponentSeriesSum(10);
        Assert.assertEquals(expected, actual);
    }

}
