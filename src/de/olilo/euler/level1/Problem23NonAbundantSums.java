package de.olilo.euler.level1;

import de.olilo.util.Divisors;

import java.util.HashSet;
import java.util.Set;

class Problem23NonAbundantSums {

    private Set<Integer> abundantNumbers = new HashSet<>();
    private int biggestAbundantNumber = 0;

    public boolean isAbundantNumber(int number) {
        return Divisors.sum(number) > number;
    }

    void findNextAbundantNumber() {
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
