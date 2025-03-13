package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem13LargeSumTest {

    @Test
    public void testReadNumbersFrom() throws Exception {
        final StringReader reader = new StringReader(
                "128181818181316\n201482058382943"
        );
        final List<BigInteger> expected = new ArrayList<BigInteger>();
        expected.add(new BigInteger("128181818181316"));
        expected.add(new BigInteger("201482058382943"));
        final List<BigInteger> actual = new Problem13LargeSum().readNumbersFrom(reader);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSumOf() throws Exception {
        final List<BigInteger> largeNumbers = new ArrayList<BigInteger>();
        largeNumbers.add(new BigInteger("23424324324"));
        largeNumbers.add(new BigInteger("12141121231"));
        final BigInteger expected = new BigInteger("35565445555");
        final BigInteger actual = new Problem13LargeSum().sumOf(largeNumbers);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFirstTenDigitsOf() throws Exception {
        final BigInteger largeNumber = new BigInteger("42325133111453462414143141412");
        final String expected = "4232513311";
        final String actual = new Problem13LargeSum().firstTenDigitsOf(largeNumber);
        Assert.assertEquals(expected, actual);
    }

}
