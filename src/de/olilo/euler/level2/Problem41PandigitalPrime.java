package de.olilo.euler.level2;

import java.util.ArrayList;
import java.util.List;

import de.olilo.util.Lists;
import de.olilo.util.PrimesIterable;

class Problem41PandigitalPrime {

    protected List<List<Integer>> generateAllPandigitalNumbersWithLength(int length) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            digits.add(i);
        }
        return Lists.generatePermutation(digits);
    }

    public int findLargestPandigitalPrime() {
        int largestFoundPandigitalPrime = 0;
        for (List<Integer> number : generateAllPandigitalNumbersWithLength(7)) {
            StringBuilder pandigitalAsString = new StringBuilder();
            for (int digit : number) {
                pandigitalAsString.append(digit);
            }
            int possiblePandigitalNumber = Integer.parseInt(pandigitalAsString.toString());
            if (PrimesIterable.INSTANCE.isPrime(possiblePandigitalNumber) && possiblePandigitalNumber > largestFoundPandigitalPrime) {
                largestFoundPandigitalPrime = possiblePandigitalNumber;
            }
        }

        return largestFoundPandigitalPrime;
    }

}
