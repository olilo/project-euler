package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

public class Problem36DoubleBasePalindromesTest {

    @Test
    public void testReverse() throws Exception {
        final String expected = "arbez";
        final String actual = new Problem36DoubleBasePalindromes().reverse("zebra");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindPalindromesInBaseTenAndTwoUntil() throws Exception {
        final int expected = 5;
        final int actual = new Problem36DoubleBasePalindromes().findPalindromesInBaseTenAndTwoUntil(10).size();
        Assert.assertEquals(expected, actual);
    }

}
