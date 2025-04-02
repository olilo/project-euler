package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.IOException;
import java.math.BigInteger;

public class Problem48SelfPowers implements Problem {

    @Override
    public String getMessage() {
        return "The last 10 digits of the sum of the series 1¹ + 2² + ... + 1000^1000 are: ";
    }

    @Override
    public int getProblemNumber() {
        return 48;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return getExponentSeriesSum(1000).mod(BigInteger.valueOf(10).pow(10));
    }

    protected BigInteger getExponentSeriesSum(int n) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            sum = sum.add(BigInteger.valueOf(i).pow(i));
        }
        return sum;
    }

}
