package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Problem24LexicographicPermutationsTest {

    @Test
    public void testFacultyOf() throws Exception {
        final long expected = 720;
        final long actual = new Problem24LexicographicPermutations().facultyOf(6);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNthPermutationOf() throws Exception {
        final int[] expected = new int[] {1, 2, 0};
        final int[] actual = new Problem24LexicographicPermutations().nthPermutationOf(new int[]{0, 1, 2}, 4);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNthPermutationOf2() throws Exception {
        final int[] expected = new int[] {1, 0, 3, 2};
        final int[] actual = new Problem24LexicographicPermutations().nthPermutationOf(new int[] {0, 1, 2, 3}, 8);
        Assert.assertArrayEquals(expected, actual);
    }
}