package de.olilo.euler.level2;

import de.olilo.util.Divisors;

import java.util.Arrays;

class Problem32PandigitalProducts {

    public int pandigitalProductSum(int limit) {
        int sum = 0;
        for (int i = 1000; i <= limit; i++) {
            if (isPandigitalProduct(i)) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Checks if a given number can be written as a pandigital product.
     * This means that its multiplicand, multiplier and product contains all digits
     * 1 to 9 exactly once.
     *
     * Example: 39 x 186 = 7254
     *
     * @param product the product to test (checks against all divisors)
     * @return true if given product is a pandigital product, false otherwise
     */
    public boolean isPandigitalProduct(int product) {
        final boolean[] digits = new boolean[9];
        setDigitsOf(Integer.toString(product), digits);
        final long[] divisors = Divisors.of(product);
        for (int i = 1; i < divisors.length / 2; i++) {
            final boolean[] digitsCopy = Arrays.copyOf(digits, 9);
            setDigitsOf(Long.toString(divisors[i]), digitsCopy);
            setDigitsOf(Long.toString(divisors[divisors.length - i - 1]), digitsCopy);
            if (isAllSet(digitsCopy)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAllSet(boolean[] digits) {
        for (boolean digitSet : digits) {
            if (!digitSet) {
                return false;
            }
        }
        return true;
    }

    private void setDigitsOf(String numberString, boolean[] digits) {
        for (char digit : numberString.toCharArray()) {
            if (Character.getNumericValue(digit) == 0) continue;
            digits[Character.getNumericValue(digit) - 1] = true;
        }
    }

}
