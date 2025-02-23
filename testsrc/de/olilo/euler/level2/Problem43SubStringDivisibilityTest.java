package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Problem43SubStringDivisibilityTest {

    @Test
    public void testGenerateFirstPandigitalNumberIncludingZero() {
        final List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        final List<Integer> actual = new Problem43SubStringDivisibility().generateFirstPandigitalNumberIncludingZero();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsSubDivisible() {
        final boolean expected = true;
        final boolean actual = new Problem43SubStringDivisibility().isSubDivisible(List.of(1, 4, 0, 6, 3, 5, 7, 2, 8, 9));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsSubDivisibleFalse() {
        final boolean expected = false;
        final boolean actual = new Problem43SubStringDivisibility().isSubDivisible(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(expected, actual);
    }
}
