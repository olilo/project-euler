package de.olilo.euler.level21;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class Problem517RealRecursionTest {

    @Test
    public void testG() throws Exception {
        final BigInteger expected = BigInteger.valueOf(7564511);
        final BigInteger actual = new Problem517RealRecursion().G(90);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testG2() throws Exception {
        final BigInteger expected = BigInteger.valueOf(6840);
        final BigInteger actual = new Problem517RealRecursion().G(40);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testG3() throws Exception {
        final BigInteger expected = new BigInteger(
                "162361380594456075128847055595792189705889888986795952740437370697025910956724159692623362356013405710304857");
        final BigInteger actual = new Problem517RealRecursion().G(6_000);
        Assert.assertEquals(expected, actual);
    }

}
