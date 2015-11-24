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

    public boolean isPandigitalProduct(int product) {
        final String productString = Integer.toString(product);
        final boolean[] digits = new boolean[9];
        for (char digit : productString.toCharArray()) {
            if (new Integer(digit + "") == 0) continue;
            digits[new Integer(digit + "") - 1] = true;
        }
        final long[] divisors = Divisors.of(product);
        for (int i = 1; i < divisors.length / 2; i++) {
            final boolean[] digitsCopy = Arrays.copyOf(digits, 9);
            final String firstDivisor = Long.toString(divisors[i]);
            final String secondDivisor = Long.toString(divisors[divisors.length - i - 1]);
            for (char digit : firstDivisor.toCharArray()) {
                if (new Integer(digit + "") == 0) continue;
                digitsCopy[new Integer(digit + "") - 1] = true;
            }
            for (char digit : secondDivisor.toCharArray()) {
                if (new Integer(digit + "") == 0) continue;
                digitsCopy[new Integer(digit + "") - 1] = true;
            }
            boolean allSet = true;
            for (boolean digitSet : digitsCopy) {
                if (!digitSet) {
                    allSet = false;
                    break;
                }
            }
            if (allSet) {
                return true;
            }
        }
        return false;
    }

}
