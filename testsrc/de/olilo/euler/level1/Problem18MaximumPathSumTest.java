package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;

public class Problem18MaximumPathSumTest {
    @Test
    public void testReadTriangle() throws Exception {
        final String input = "" +
                "   3\n" +
                "  7 4\n" +
                " 2 4 6\n" +
                "8 5 9 3\n";

        final int[][] expected = new int[][] {
                {3},
                {7, 4},
                {2, 4, 6},
                {8, 5, 9, 3}
        };
        final int[][] actual = new Problem18MaximumPathSum().readTriangle(new StringReader(input));
        Assert.assertArrayEquals(expected, actual);
    }

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
