package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;
import java.math.BigInteger;

public class Problem8GreatestProductTest {

    @Test
    public void testReadNumberFrom() throws Exception {
        final StringReader reader = new StringReader("1231314\n1231231231\n12121");
        final BigInteger expected = new BigInteger("1231314123123123112121");
        final BigInteger actual = new Problem8GreatestProduct().readNumberFrom(reader);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGreatestProduct() throws Exception {
        final long expected = 30;
        final long actual = new Problem8GreatestProduct().greatestProduct(new BigInteger("12152312"), 3);
        Assert.assertEquals(expected, actual);
    }

}
