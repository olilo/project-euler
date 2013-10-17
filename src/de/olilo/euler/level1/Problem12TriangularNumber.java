package de.olilo.euler.level1;

import de.olilo.euler.PrimesIterable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem12TriangularNumber {

    public long findFirstTriangularNumberWithNDivisors(int minimumDivisors) {
        // FIXME either find a minimum to go off from or find a purely algorithmic approach
        int index = 1;
        long number = 1;
        int numDivisors = 1;
        while (numDivisors < minimumDivisors) {
            index++;
            number += index;

            List<Integer> primeFactors = new ArrayList<Integer>();
            Set<Long> divisors = new HashSet<Long>();
            long numberCopy = number;

            // get all prime factors
            for (int prime : PrimesIterable.INSTANCE) {
                while (numberCopy % prime == 0) {
                    primeFactors.add(prime);
                    numberCopy /= prime;
                }
                if (numberCopy == 1) {
                    break;
                }
            }

            // now construct all divisors of that number from the prime factors
            // by taking every permutation into account
            for (int i = 0; i < Math.pow(2, primeFactors.size()); i++) {
                long divisor = 1;
                for(int j = 0; j < primeFactors.size(); j++) {
                    if ((i & (2 << j) / 2) > 0) {
                        divisor *= primeFactors.get(j);
                    }
                }
                divisors.add(divisor);
            }

            numDivisors = divisors.size();
        }
        return number;
    }

}
