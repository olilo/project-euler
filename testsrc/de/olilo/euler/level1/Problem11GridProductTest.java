package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;

public class Problem11GridProductTest {
    @Test
    public void testReadGrid() throws Exception {
        final String testGrid = "" +
                "12 23 34 32 21 32\n" +
                "12 33 11 44 11 23\n" +
                "01 02 94 29 31 03\n";

        final int[][] expected =  {
                {12, 23, 34, 32, 21, 32},
                {12, 33, 11, 44, 11, 23},
                { 1,  2, 94, 29, 31,  3}
        };
        final int[][] actual = new Problem11GridProduct().readGrid(new StringReader(testGrid));
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLargestProductInWithRowGreatest() throws Exception {
        final int[][] testGrid = {
                {1, 2, 5, 8},
                {3, 2, 1, 1},
                {1, 1, 2, 1},
                {9, 1, 8, 1}
        };

        // largest is 2 * 5 * 8 (horizontally in top row)
        final long expected = 80;
        final long actual = new Problem11GridProduct().findGreatestProductIn(testGrid, new GridFactorCount(3));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindLargestProductInWithColumnGreatest() throws Exception {
        final int[][] testGrid = {
                {1, 2, 5, 1},
                {3, 2, 1, 8},
                {1, 1, 1, 2},
                {1, 1, 1, 8}
        };

        // largest is 8 * 2 * 8 (vertically in last column)
        final long expected = 128;
        final long actual = new Problem11GridProduct().findGreatestProductIn(testGrid, new GridFactorCount(3));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindLargestProductInWithDiagonalGreatest() throws Exception {
        final int[][] testGrid = {
                {1, 2, 5, 8, 1},
                {3, 2, 8, 1, 1},
                {1, 9, 2, 1, 1},
                {9, 1, 8, 1, 1},
                {1, 1, 1, 1, 1},
        };

        // largest is 9 * 9 * 8 (diagonally from bottom left)
        final long expected = 648;
        final long actual = new Problem11GridProduct().findGreatestProductIn(testGrid, new GridFactorCount(3));
        Assert.assertEquals(expected, actual);
    }
}
