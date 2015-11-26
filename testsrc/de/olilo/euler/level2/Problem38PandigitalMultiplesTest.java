package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem38PandigitalMultiplesTest {

    @Test
    public void testIsPandigital192384576() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem38PandigitalMultiples().isPandigital(192384576);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPandigital191384576() throws Exception {
        final boolean expected = false;
        final boolean actual = new Problem38PandigitalMultiples().isPandigital(191384576);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPandigital190384576() throws Exception {
        final boolean expected = false;
        final boolean actual = new Problem38PandigitalMultiples().isPandigital(190384576);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetConcatenatedProduct() throws Exception {
        final long expected = 192384576;
        final long actual = new Problem38PandigitalMultiples().getConcatenatedProduct(192, 3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBiggestPandigitalProduct() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem38PandigitalMultiples().getBiggestPandigitalProduct() > 0;
        Assert.assertEquals(expected, actual);
    }
}