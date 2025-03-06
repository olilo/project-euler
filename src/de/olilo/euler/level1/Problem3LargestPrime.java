package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.PrimeFactors;

public class Problem3LargestPrime implements Problem {

    @Override
    public String getMessage() {
        return "The largest prime factor of 600.851.475.143 is: ";
    }

    @Override
    public int getProblemNumber() {
        return 3;
    }

    @Override
    public Number runProblem(Runner runner) {
        return getLargestPrimeOf(600_851_475_143L);
    }

    protected long getLargestPrimeOf(long number) {
        // the prime factors of the number
        int[] primeFactors = PrimeFactors.of(number);
        return primeFactors[primeFactors.length - 1];
    }

}
