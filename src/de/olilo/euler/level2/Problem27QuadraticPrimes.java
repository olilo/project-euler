package de.olilo.euler.level2;

import de.olilo.util.PrimesIterable;

import java.util.*;

class Problem27QuadraticPrimes {

    private Set<Integer> primes = new HashSet<>();

    public Problem27QuadraticPrimes() {
        for (int prime : PrimesIterable.INSTANCE) {
            primes.add(prime);
            if (prime > 100000) {
                break;
            }
        }
    }

    public int getLongestChainOfQuadraticPrimes(int aLimit, int bLimit) {
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

    public int[] getQuadraticPrimes(int a, int b) {
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
