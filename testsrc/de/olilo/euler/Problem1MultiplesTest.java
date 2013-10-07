package de.olilo.euler;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @author Oliver Lorenz
 * @since 0.1
 */
public class Problem1MultiplesTest {

    @Test
    public void testSolveIteratively10() throws Exception {
        long result = new Problem1Multiples().solveIteratively(10);
        Assert.assertEquals(23L, result);
    }

    @Test
    public void testSolveIteratively1000() throws Exception {
        long result = new Problem1Multiples().solveIteratively(1000);
        Assert.assertEquals(233168L, result);
    }

    @Test
    public void testSolveIteratively10000() throws Exception {
        long result = new Problem1Multiples().solveIteratively(10000);
        Assert.assertEquals(23331668L, result);
    }

    @Test
    public void testSolveAlgorithm10() throws Exception {
        long result = new Problem1Multiples().solveByAlgorithm(10).longValue();
        Assert.assertEquals(23L, result);
    }

    @Test
    public void testSolveAlgorithm1000() throws Exception {
        long result = new Problem1Multiples().solveByAlgorithm(1000).longValue();
        Assert.assertEquals(233168L, result);
    }

    @Test
    public void testSolveAlgorithm10000() throws Exception {
        long result = new Problem1Multiples().solveByAlgorithm(10000).longValue();
        Assert.assertEquals(23331668L, result);
    }

    @Test
    public void testSolveAlgorithmMaxLong() throws Exception {
        BigInteger result = new Problem1Multiples().solveByAlgorithm(Long.MAX_VALUE);
        System.out.println("Result of " + Long.MAX_VALUE + ": " + result);
    }

}
