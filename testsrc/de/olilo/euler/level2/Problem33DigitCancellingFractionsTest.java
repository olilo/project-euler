package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Problem33DigitCancellingFractionsTest {

    @Test
    public void testIsDigitCancellingFraction() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem33DigitCancellingFractions().isDigitCancellingFraction(49, 98);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsDigitCancellingFractionNot() throws Exception {
        final boolean expected = false;
        final boolean actual = new Problem33DigitCancellingFractions().isDigitCancellingFraction(48, 98);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsDigitCancellingFractionTrivial() throws Exception {
        final boolean expected = false;
        final boolean actual = new Problem33DigitCancellingFractions().isDigitCancellingFraction(40, 80);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDigitCancellingFractionsBetween() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem33DigitCancellingFractions().
                getDigitCancellingFractionsBetween(49, 98).get(49) == 98;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDigitCancellingFractionsBetween10And99() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem33DigitCancellingFractions().
                getDigitCancellingFractionsBetween(10, 99).size() == 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetProductOf() throws Exception {
        final Map<Integer, Integer> input = new HashMap<>();
        input.put(3, 10);
        input.put(2, 3);
        input.put(49, 98);

        final Map.Entry<Integer, Integer> expected = new AbstractMap.SimpleEntry<>(1, 10);
        final Map.Entry<Integer, Integer> actual = new Problem33DigitCancellingFractions().getProductOf(input);
        Assert.assertEquals(expected, actual);
    }

}