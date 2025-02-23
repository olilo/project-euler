package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.PrimesIterable;

public class Problem10SumOfPrimes implements Problem {

    @Override
    public String getMessage() {
        return "The sum of all primes up to 2.000.000 is: ";
    }

    @Override
    public int getProblemNumber() {
        return 10;
    }

    @Override
    public Number runProblem(Runner runner) {
        return sumOfPrimesUpTo(2_000_000);
    }

    protected long sumOfPrimesUpTo(int limit) {
        long sum = 0;
        for (int prime : PrimesIterable.INSTANCE) {
            if (prime <= limit) {
                sum += prime;
            } else {
                break;
            }
        }
        return sum;
    }
}
