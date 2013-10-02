package de.olilo.euler;

import org.junit.Assert;
import org.junit.Test;

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
    public void testSolveAlgorithm10() throws Exception {
        long result = new Problem1Multiples().solveByAlgorithm(10);
        Assert.assertEquals(23L, result);
    }

    @Test
    public void testSolveAlgorithm1000() throws Exception {
        long result = new Problem1Multiples().solveByAlgorithm(1000);
        Assert.assertEquals(233168L, result);
    }

}
