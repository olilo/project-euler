package de.olilo.euler.level1;

import de.olilo.euler.level1.Problem4Palindrome;
import junit.framework.Assert;
import org.junit.Test;

public class Problem4PalindromeTest {
    @Test
    public void testFindBiggestPalindromeFromTwoNDigitedNumbers() throws Exception {
        final long expected = 9009;
        final long actual = new Problem4Palindrome().findBiggestPalindromeFromTwoNDigitedNumbers(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPalindrome9009() throws Exception {
        Assert.assertTrue(new Problem4Palindrome().isPalindrome(9009));
    }

    @Test
    public void testIsPalindrome4939() throws Exception {
        Assert.assertFalse(new Problem4Palindrome().isPalindrome(4939));
    }
}
