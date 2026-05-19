package de.olilo.euler.level2;

import de.olilo.util.Numbers;
import de.olilo.util.PrimesIterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Numbers;
import de.olilo.util.PrimesIterable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem37TruncatablePrimes implements Problem {

    @Override
    public String getMessage() {
        return "The sum of the only eleven primes that are both truncatable from left to right and right to left is: ";
    }

    @Override
    public int getProblemNumber() {
        return 37;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return findAllTruncatablePrimes().stream().reduce(0, Integer::sum);
    }

    public List<Integer> findAllTruncatablePrimes() {
        final List<Integer> truncatablePrimes = new ArrayList<>();
        final Iterator<Integer> primes = PrimesIterable.INSTANCE.iterator();
        while (truncatablePrimes.size() < 11) {
            final int prime = primes.next();
            if (prime < 10) {
                continue;
            }
            if (isTruncatablePrime(prime)) {
                truncatablePrimes.add(prime);
            }
        }
        return truncatablePrimes;
    }

    public boolean isTruncatablePrime(int prime) {
        final String primeString = Integer.toString(prime);
        for (int i = 1; i < primeString.length(); i++) {
            if (Numbers.isComposite(Integer.parseInt(primeString.substring(i)))) {
                return false;
            }
        }
        for (int i = primeString.length(); i >= 1; i--) {
            if (Numbers.isComposite(Integer.parseInt(primeString.substring(0, i)))) {
                return false;
            }
        }
        return true;
    }

}
