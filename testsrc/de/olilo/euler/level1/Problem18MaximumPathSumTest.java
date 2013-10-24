package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

public class Problem18MaximumPathSumTest {
    @Test
    public void testMaximumPathSumOf() throws Exception {
        final int[][] input = new int[][] {
                {3},
                {7, 4},
                {2, 4, 6},
                {8, 5, 9, 3}
        };
        final long expected = 23;
        final long actual = new Problem18MaximumPathSum().maximumPathSumOf(input);
        Assert.assertEquals(expected, actual);
    }
}
