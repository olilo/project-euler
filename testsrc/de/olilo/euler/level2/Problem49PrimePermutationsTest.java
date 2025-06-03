package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem49PrimePermutationsTest {

    @Test
    public void testFindPrimeSequence() {
        final int[] expected = new int[] {1487, 4817, 8147};
        final int[] actual = new Problem49PrimePermutations().findPrimeSequenceAfter(1_000);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testIsPrimeSequence() {
        final boolean expected = true;
        final boolean actual = new Problem49PrimePermutations().isPrimeSequence(1009, 12);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPrimeSequenceFalse() {
        final boolean expected = false;
        final boolean actual = new Problem49PrimePermutations().isPrimeSequence(1019, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testArePermutationsOfEachOther() {
        final boolean expected = true;
        final boolean actual = new Problem49PrimePermutations().arePermutationsOfEachOther(1487, 4817, 8147);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSortedString() {
        final String expected = "adhry";
        final String actual = new Problem49PrimePermutations().getSortedString("hardy");
        Assert.assertEquals(expected, actual);
    }

}
