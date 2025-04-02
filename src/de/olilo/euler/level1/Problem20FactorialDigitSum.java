package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.IOException;
import java.math.BigInteger;

public class Problem20FactorialDigitSum implements Problem {

    @Override
    public String getMessage() {
        return "The sum of the digits in the number 100! is: ";
    }

    @Override
    public int getProblemNumber() {
        return 20;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return getFactorialDigitSum(100);
    }

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
