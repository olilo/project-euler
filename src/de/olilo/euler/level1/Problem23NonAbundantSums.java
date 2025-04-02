package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Divisors;

import java.util.HashSet;
import java.util.Set;

public class Problem23NonAbundantSums implements Problem {

    private final Set<Integer> abundantNumbers = new HashSet<>();
    private int biggestAbundantNumber = 0;

    @Override
    public String getMessage() {
        return "The sum of all the positive integers which cannot be written as the sum of two abundant numbers is: ";
    }

    @Override
    public int getProblemNumber() {
        return 23;
    }

    @Override
    public Number runProblem(Runner runner) {
        return sumOfNonAbundantSumsUntil(28123);
    }

    public boolean isAbundantNumber(int number) {
        return Divisors.sum(number) > number;
    }

    protected void findNextAbundantNumber() {
        int current = biggestAbundantNumber + 1;
        while (!isAbundantNumber(current)) {
            current++;
        }
        abundantNumbers.add(current);
        biggestAbundantNumber = current;
    }

    public boolean isSumOfAbundantNumbers(int number) {
        while (biggestAbundantNumber < number) {
            findNextAbundantNumber();
        }

        for (int abundantNumber : abundantNumbers) {
            if (abundantNumbers.contains(number - abundantNumber)) {
                return true;
            }
        }
        return false;
    }

    public int sumOfNonAbundantSumsUntil(int limit) {
        int sum = 0;
        for (int current = 1; current <= limit; current++) {
            if (!isSumOfAbundantNumbers(current)) {
                sum += current;
            }
        }
        return sum;
    }

}
