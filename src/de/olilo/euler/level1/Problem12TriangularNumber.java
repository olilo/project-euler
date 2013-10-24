package de.olilo.euler.level1;

import de.olilo.euler.PrimesIterable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem12TriangularNumber {

    public long findFirstTriangularNumberWithNDivisors(int minimumDivisors) {
        // FIXME either find a minimum to go off from or find a purely algorithmic approach
        int index = 1;
        long number = 1;
        int numDivisors = 1;

        while (numDivisors < minimumDivisors) {
            index++;
            number += index;

            // get all prime factors
            final List<Integer> primeFactors = getPrimeFactorsFor(number);

            // now construct all divisors of that number from the prime factors
            // by taking every permutation into account
            numDivisors = getNumberOfDivisorsForPrimeFactors(primeFactors);
        }

        return number;
    }

    List<Integer> getPrimeFactorsFor(long number) {
        final List<Integer> primeFactors = new ArrayList<Integer>();

        for (int prime : PrimesIterable.INSTANCE) {
            while (number % prime == 0) {
                primeFactors.add(prime);
                number /= prime;
            }
            if (number == 1) {
                break;
            }
        }

        return primeFactors;
    }

    int getNumberOfDivisorsForPrimeFactors(final List<Integer> primeFactors) {
        // FIXME is there an algorithm to calculate this, with filtering out duplicates?
        // use a set to filter out duplicates
        final Set<Long> divisors = new HashSet<Long>();

        for (int i = 0; i < Math.pow(2, primeFactors.size()); i++) {
            long divisor = 1;
            for(int j = 0; j < primeFactors.size(); j++) {
                if ((i & (2 << j) / 2) > 0) {
                    divisor *= primeFactors.get(j);
                }
            }
            divisors.add(divisor);
        }

        return divisors.size();
    }

}
