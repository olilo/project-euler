package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.PrimesIterable;

import java.io.IOException;
import java.util.*;

public class Problem27QuadraticPrimes implements Problem {

    private final Set<Integer> primes = new HashSet<>();

    public Problem27QuadraticPrimes() {
        for (int prime : PrimesIterable.INSTANCE) {
            primes.add(prime);
            if (prime > 100_000) {
                break;
            }
        }
    }

    @Override
    public String getMessage() {
        return "The product of coefficients a and b that produce a maximum number of primes for n² + an + b is: ";
    }

    @Override
    public int getProblemNumber() {
        return 27;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return getLongestChainOfQuadraticPrimes(1000, 1000);
    }

    protected int getLongestChainOfQuadraticPrimes(int aLimit, int bLimit) {
        int longestChain = 0;
        int greatestA = 0;
        int greatestB = 0;
        for (int a = -aLimit + 1; a < aLimit; a++) {
            for (int b = -bLimit + 1; b < bLimit; b++) {
                int primesChain = getQuadraticPrimes(a, b).length;
                if (primesChain > longestChain) {
                    longestChain = primesChain;
                    greatestA = a;
                    greatestB = b;
                }
            }
        }
        return greatestA * greatestB;
    }

    protected int[] getQuadraticPrimes(int a, int b) {
        List<Integer> foundPrimes = new ArrayList<>();
        int n = 0;
        while (primes.contains((int) (Math.pow(n, 2) + a * n + b))) {
            foundPrimes.add((int) (Math.pow(n, 2) + a * n + b));
            n++;
        }
        int[] result = new int[foundPrimes.size()];
        for (int i = 0; i < foundPrimes.size(); i++) {
            result[i] = foundPrimes.get(i);
        }
        return result;
    }
}
