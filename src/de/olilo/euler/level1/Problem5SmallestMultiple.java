package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.math.BigInteger;

public class Problem5SmallestMultiple implements Problem {

    @Override
    public String getMessage() {
        return "The smallest number that is evenly divisible by all numbers from 1 to 20 is: ";
    }

    @Override
    public int getProblemNumber() {
        return 5;
    }

    @Override
    public Number runProblem(Runner runner) {
        return findSmallestMultipleUpTo(20);
    }

    protected BigInteger findSmallestMultipleUpTo(int limit) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= limit; i++) {
            result = result.multiply(BigInteger.valueOf(i)).divide(result.gcd(BigInteger.valueOf(i)));
        }
        return result;
    }

}
