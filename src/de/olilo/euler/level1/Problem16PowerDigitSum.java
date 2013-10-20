package de.olilo.euler.level1;

import java.math.BigInteger;

public class Problem16PowerDigitSum {

    public long digitSumOfTwoToThePowerOf(final int exponent) {
        final BigInteger power = new BigInteger("2").pow(exponent);
        long sum = 0;
        for (char digit : power.toString().toCharArray()) {
            sum += Character.digit(digit, 10);
        }
        return sum;
    }

}
