package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

public class Problem4Palindrome implements Problem {

    @Override
    public String getMessage() {
        return "The biggest palindrome that is the product of two 3-digit numbers is: ";
    }

    @Override
    public int getProblemNumber() {
        return 4;
    }

    @Override
    public Number runProblem(Runner runner) {
        return findBiggestPalindromeFromTwoNDigitedNumbers(3);
    }

    protected long findBiggestPalindromeFromTwoNDigitedNumbers(int digits) {
        long max = (long) Math.pow(10, digits) - 1;
        long min = max - (long) Math.pow(10, digits - 1);
        long number1 = max;
        long number2 = max;
        long result = 0;
        while (number2 >= min) {
            number1--;
            if (number1 <= min) {
                number1 = max;
                number2--;
                if (number1 * number2 < result) {
                    break;
                }
            }
            if (isPalindrome(number1 * number2)) {
                result = Math.max(result, number1 * number2);
            }
        }
        return result;
    }

    protected boolean isPalindrome(long number) {
        final String original = Long.toString(number);
        return new StringBuilder(original).reverse().toString().equalsIgnoreCase(original);
    }

}
