package de.olilo.euler.level3;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Problem52PermutedMultiplesTest {

    @Test
    public void testIsPermutedMultiple() {
        final boolean expected = true;
        final boolean actual = new Problem52PermutedMultiples().isPermutedMultiple(List.of(125874, 251748));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPermutedMultipleMore() {
        final boolean expected = true;
        final boolean actual = new Problem52PermutedMultiples().isPermutedMultiple(List.of(125814, 251148, 412518, 251184));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPermutedMultipleFalse() {
        final boolean expected = false;
        final boolean actual = new Problem52PermutedMultiples().isPermutedMultiple(List.of(125874, 251748, 941518));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertIntegerToSortedDigits() {
        final List<Integer> expected = List.of(1, 2, 3, 7, 8);
        final List<Integer> actual = new Problem52PermutedMultiples().convertIntegerToSortedDigits(21387);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertIntegerToSortedDigitsBigger() {
        final List<Integer> expected = List.of(1, 1, 2, 2, 3, 7, 7, 8, 9);
        final List<Integer> actual = new Problem52PermutedMultiples().convertIntegerToSortedDigits(921721387);
        Assert.assertEquals(expected, actual);
    }

}
