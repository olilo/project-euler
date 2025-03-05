package de.olilo.euler.level3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Problem51PrimeDigitReplacementsTest {

    @Test
    public void testReplaceDigits() {
        final List<Integer> expected = List.of(56003, 56113, 56223, 56333, 56443, 56553, 56663, 56773, 56883, 56993);
        final List<Integer> actual = new Problem51PrimeDigitReplacements().replaceDigits("56003", Set.of(2, 3));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceDigitsSmall() {
        final List<Integer> expected = List.of(13, 23, 33, 43, 53, 63, 73, 83, 93);
        final List<Integer> actual = new Problem51PrimeDigitReplacements().replaceDigits("13", Set.of(0));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceDigitsLeadingZeroes() {
        final List<Integer> expected = List.of(113, 223, 333, 443, 553, 663, 773, 883, 993);
        final List<Integer> actual = new Problem51PrimeDigitReplacements().replaceDigits("123", Set.of(0, 1));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceDigitsFirst() {
        final List<Integer> expected = List.of(18315, 28325, 38335, 48345, 58355, 68365, 78375, 88385, 98395);
        final List<Integer> actual = new Problem51PrimeDigitReplacements().replaceDigits("18345", Set.of(0, 3));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetChainLengthFor6() {
        final int expected = 6;
        final int actual = new Problem51PrimeDigitReplacements().getChainLengthFor("13", Set.of(0));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetChainLengthFor7() {
        final int expected = 7;
        final int actual = new Problem51PrimeDigitReplacements().getChainLengthFor("56003", Set.of(2, 3));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFilterLeadingZeroes() {
        final String expected = "12305";
        final String actual = new Problem51PrimeDigitReplacements().filterLeadingZeroes("0012305");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFilterLeadingZeroesWithNoLeadingZeroes() {
        final String expected = "12305";
        final String actual = new Problem51PrimeDigitReplacements().filterLeadingZeroes("12305");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFilterLeadingZeroesOfZero() {
        final String expected = "0";
        final String actual = new Problem51PrimeDigitReplacements().filterLeadingZeroes("000");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDigitSets() {
        final List<Collection<Integer>> expected = List.of(Set.of(0), Set.of(0, 1), Set.of(1));
        final List<Collection<Integer>> actual = new Problem51PrimeDigitReplacements().generateDigitSets(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDigitSetsLength3() {
        final List<Collection<Integer>> expected = List.of(Set.of(0), Set.of(0, 2), Set.of(0, 1), Set.of(0, 1, 2), Set.of(1), Set.of(1, 2), Set.of(2));
        final List<Collection<Integer>> actual = new Problem51PrimeDigitReplacements().generateDigitSets(3);
        Assert.assertEquals(expected, actual);
    }

}
