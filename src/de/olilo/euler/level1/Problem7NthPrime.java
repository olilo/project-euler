package de.olilo.euler.level1;

import de.olilo.euler.PrimesIterable;

public class Problem7NthPrime {

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
