package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Problem42CodedTriangleNumbersTest {

    @Test
    public void testConvertToWordValue() {
        final int expected = 55;
        final int actual = new Problem42CodedTriangleNumbers().convertToWordValue("SKY");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertToWordValueWithLowerCase() {
        final int expected = 9;
        final int actual = new Problem42CodedTriangleNumbers().convertToWordValue("ace");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertToWordValueEmptyString() {
        final int expected = 0;
        final int actual = new Problem42CodedTriangleNumbers().convertToWordValue("");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumber1() {
        final boolean expected = true;
        final boolean actual = new Problem42CodedTriangleNumbers().isTriangleNumber(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumberWithDevilsNumber() {
        final boolean expected = true;
        final boolean actual = new Problem42CodedTriangleNumbers().isTriangleNumber(666);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumber() {
        final boolean expected = true;
        final boolean actual = new Problem42CodedTriangleNumbers().isTriangleNumber(55);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumberFalse() {
        final boolean expected = false;
        final boolean actual = new Problem42CodedTriangleNumbers().isTriangleNumber(53);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountTriangleWords() {
        final int expected = 1;
        final int actual = new Problem42CodedTriangleNumbers().countTriangleWords(List.of("SKY", "ape", "AbLe"));
        Assert.assertEquals(expected, actual);
    }
}
