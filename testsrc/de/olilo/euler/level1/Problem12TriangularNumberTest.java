package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem12TriangularNumberTest {
    @Test
    public void testFindFirstTriangularNumberWithNDivisors() throws Exception {
        final long expected = 28;
        final long actual = new Problem12TriangularNumber().findFirstTriangularNumberWithNDivisors(5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPrimeFactorsFor() throws Exception {
        final List<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(2);
        expected.add(3);
        expected.add(5);
        final List<Integer> actual = new Problem12TriangularNumber().getPrimeFactorsFor(60);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberOfDivisorsForPrimeFactors() throws Exception {
        final List<Integer> primeFactors = new ArrayList<Integer>();
        primeFactors.add(2);
        primeFactors.add(2);
        primeFactors.add(7);

        final int expected = 6;
        final int actual = new Problem12TriangularNumber().getNumberOfDivisorsForPrimeFactors(primeFactors);
        Assert.assertEquals(expected, actual);
    }
}
