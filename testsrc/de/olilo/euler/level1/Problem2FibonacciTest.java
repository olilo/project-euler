package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem2FibonacciTest {

    @Test
    public void testSolve15() throws Exception {
        long expected = 10L;
        long actual = new Problem2Fibonacci().solve(15);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSolve40() throws Exception {
        long expected = 44L;
        long actual = new Problem2Fibonacci().solve(40);
        Assert.assertEquals(expected, actual);
    }

}
