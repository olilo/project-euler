package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem46GoldbachsOtherConjectureTest {

    @Test
    public void testIsNotWritableAsPrimeAndTwiceSquare() {
        final boolean expected = false;
        final boolean actual = new Problem46GoldbachsOtherConjecture().isNotWritableAsPrimeAndTwiceSquare(9);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsNotWritableAsPrimeAndTwiceSquare33() {
        final boolean expected = false;
        final boolean actual = new Problem46GoldbachsOtherConjecture().isNotWritableAsPrimeAndTwiceSquare(33);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsNotWritableAsPrimeAndTwiceSquareTrue() {
        final boolean expected = true;
        final boolean actual = new Problem46GoldbachsOtherConjecture().isNotWritableAsPrimeAndTwiceSquare(5777);
        Assert.assertEquals(expected, actual);
    }

}
