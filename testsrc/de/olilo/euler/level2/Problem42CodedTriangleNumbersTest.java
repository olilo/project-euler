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
    public void testCountTriangleWords() {
        final int expected = 1;
        final int actual = new Problem42CodedTriangleNumbers().countTriangleWords(List.of("SKY", "ape", "AbLe"));
        Assert.assertEquals(expected, actual);
    }
}
