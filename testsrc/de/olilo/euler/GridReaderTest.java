package de.olilo.euler;

import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;

public class GridReaderTest {

    @Test
    public void testReadRectangle() throws Exception {
        final String testGrid = "" +
                " 12 23 34 32 21 32  \n" +
                " 12 33 11 44 11 23  \n" +
                " 01  2 94 29 31 03  \n";

        final int[][] expected =  {
                {12, 23, 34, 32, 21, 32},
                {12, 33, 11, 44, 11, 23},
                { 1,  2, 94, 29, 31,  3}
        };
        final int[][] actual = new GridReader(new StringReader(testGrid)).readGrid();
        Assert.assertArrayEquals(expected, actual);
    }

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
        final int[][] actual = new GridReader(new StringReader(input)).readGrid();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWithoutAutoclose() throws Exception {
        final String input = "" +
                "123 01\n" +
                "121 21\n";
        final int[][] expected = new int[][] {
                {123, 1},
                {121, 21}
        };
        final StringReader reader = new StringReader(input);
        final int[][] actual = new GridReader(reader).setCloseOnFinish(false).readGrid();
        Assert.assertArrayEquals(expected, actual);
        Assert.assertTrue(reader.ready());
    }

}
