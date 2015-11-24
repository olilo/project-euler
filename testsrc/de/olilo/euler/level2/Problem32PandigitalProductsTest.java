package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem32PandigitalProductsTest {

    @Test
    public void testIsPandigitalProduct7254() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem32PandigitalProducts().isPandigitalProduct(7254);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPandigitalProduct7253() throws Exception {
        final boolean expected = false;
        final boolean actual = new Problem32PandigitalProducts().isPandigitalProduct(7253);
        Assert.assertEquals(expected, actual);
    }

}