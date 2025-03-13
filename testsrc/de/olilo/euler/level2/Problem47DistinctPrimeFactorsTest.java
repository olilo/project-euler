package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem47DistinctPrimeFactorsTest {

    @Test
    public void testFindFirstOfConsecutiveIntegersWithNDistinctPrimeFactorsTwo() {
        final int expected = 14;
        final int actual = new Problem47DistinctPrimeFactors().findFirstOfConsecutiveIntegersWithNDistinctPrimeFactors(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindFirstOfConsecutiveIntegersWithNDistinctPrimeFactorsThree() {
        final int expected = 644;
        final int actual = new Problem47DistinctPrimeFactors().findFirstOfConsecutiveIntegersWithNDistinctPrimeFactors(3);
        Assert.assertEquals(expected, actual);
    }

}
