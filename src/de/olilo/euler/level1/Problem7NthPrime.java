package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.PrimesIterable;

public class Problem7NthPrime implements Problem {

    @Override
    public String getMessage() {
        return "The 10001st prime number is: ";
    }

    @Override
    public int getProblemNumber() {
        return 7;
    }

    @Override
    public Number runProblem(Runner runner) {
        return getNthPrime(10001);
    }

    public int getNthPrime(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        int counter = 0;
        for (int prime : PrimesIterable.INSTANCE) {
            counter++;
            if (counter == n) {
                return prime;
            }
        }
        // shouldn't be reachable
        throw new IllegalStateException("We shouldn't have exited the for loop...");
    }

}
