package de.olilo.euler.level1;

import de.olilo.euler.PrimesIterable;

class Problem10SumOfPrimes {

    public long sumOfPrimesUpTo(int limit) {
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
