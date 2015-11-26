package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem37TruncatablePrimesTest {

    @Test
    public void testIsTruncatablePrime3797() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem37TruncatablePrimes().isTruncatablePrime(3797);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTruncatablePrime23() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem37TruncatablePrimes().isTruncatablePrime(23);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTruncatablePrime41() throws Exception {
        final boolean expected = false;
        final boolean actual = new Problem37TruncatablePrimes().isTruncatablePrime(41);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllTruncatablePrimes() throws Exception {
        final int expected = 11;
        final int actual = new Problem37TruncatablePrimes().findAllTruncatablePrimes().size();
        Assert.assertEquals(expected, actual);
    }
}