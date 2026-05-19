package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Numbers;
import de.olilo.util.PrimesIterable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Problem35CircularPrimes implements Problem {

    @Override
    public String getMessage() {
        return "The amount of circular primes below one million is: ";
    }

    @Override
    public int getProblemNumber() {
        return 35;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return getCircularPrimesUntil(1_000_000).size();
    }

    protected List<Integer> getCircularPrimesUntil(int limit) {
        final List<Integer> result = new ArrayList<>();
        for (int prime : PrimesIterable.INSTANCE) {
            if (prime > limit) {
                return result;
            }
            if (isCircularPrime(prime)) {
                result.add(prime);
            }
        }
        return result;
    }

    protected boolean isCircularPrime(int number) {
        final char[] digits = Integer.toString(number).toCharArray();
        for (int i = 1; i < digits.length; i++) {
            StringBuilder probablePrime = new StringBuilder();
            for (int j = i; j < i + digits.length; j++) {
                probablePrime.append(digits[j % digits.length]);
            }
            if (Numbers.isComposite(Integer.parseInt(probablePrime.toString()))) {
                return false;
            }
        }
        return true;
    }

}
