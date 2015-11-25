package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem36DoubleBasePalindromesTest {

    @Test
    public void testIsPalindrome() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem36DoubleBasePalindromes().isPalindrome("50105");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPalindromeMaoaM() throws Exception {
        final boolean expected = true;
        final boolean actual = new Problem36DoubleBasePalindromes().isPalindrome("MaoaM");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPalindromeNot() throws Exception {
        final boolean expected = false;
        final boolean actual = new Problem36DoubleBasePalindromes().isPalindrome("abead");
        Assert.assertEquals(expected, actual);
    }

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