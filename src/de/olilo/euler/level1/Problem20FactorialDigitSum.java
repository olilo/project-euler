package de.olilo.euler.level1;

import java.math.BigInteger;

public class Problem20FactorialDigitSum {

    public int getFactorialDigitSum(int upTo) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= upTo; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        int digitSum = 0;
        for (char digit : factorial.toString().toCharArray()) {
            digitSum += Integer.parseInt("" + digit);
        }
        return digitSum;
    }

}
