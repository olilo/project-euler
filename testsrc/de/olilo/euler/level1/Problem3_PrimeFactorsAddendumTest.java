package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class Problem3_PrimeFactorsAddendumTest {

    @Test
    public void testFindSmallestNumberWithNDistinctPrimeFactors() throws Exception {
        BigInteger expected = BigInteger.valueOf(2 * 3 * 5 * 7 * 11);
        BigInteger actual = new Problem3PrimeFactorsAddendum().findSmallestNumberWithNDistinctPrimeFactors(5);
        Assert.assertEquals(expected, actual);
    }
}
