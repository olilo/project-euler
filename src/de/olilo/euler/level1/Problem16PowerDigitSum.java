package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.math.BigInteger;

public class Problem16PowerDigitSum implements Problem {

    @Override
    public String getMessage() {
        return "The sum of the digits of the number 2^1000 is: ";
    }

    @Override
    public int getProblemNumber() {
        return 16;
    }

    @Override
    public Number runProblem(Runner runner) {
        return digitSumOfTwoToThePowerOf(1_000);
    }

    protected long digitSumOfTwoToThePowerOf(final int exponent) {
        final BigInteger power = new BigInteger("2").pow(exponent);
        long sum = 0;
        for (char digit : power.toString().toCharArray()) {
            sum += Character.digit(digit, 10);
        }
        return sum;
    }

}
