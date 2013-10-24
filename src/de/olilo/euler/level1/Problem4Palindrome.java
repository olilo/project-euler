package de.olilo.euler.level1;

class Problem4Palindrome {

    public long findBiggestPalindromeFromTwoNDigitedNumbers(int digits) {
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

    boolean isPalindrome(long number) {
        final String original = Long.toString(number);
        return new StringBuilder(original).reverse().toString().equalsIgnoreCase(original);
    }

}
