package de.olilo.euler.level2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Lists;
import de.olilo.util.Numbers;

public class Problem41PandigitalPrime implements Problem {

    @Override
    public String getMessage() {
        return "The largest pandigital prime that exists is: ";
    }

    @Override
    public int getProblemNumber() {
        return 41;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return findLargestPandigitalPrime();
    }

    protected List<List<Integer>> generateAllPandigitalNumbersWithLength(int length) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            digits.add(i);
        }
        return Lists.generatePermutation(digits);
    }

    protected int findLargestPandigitalPrime() {
        int largestFoundPandigitalPrime = 0;
        for (List<Integer> number : generateAllPandigitalNumbersWithLength(7)) {
            StringBuilder pandigitalAsString = new StringBuilder();
            for (int digit : number) {
                pandigitalAsString.append(digit);
            }
            int possiblePandigitalNumber = Integer.parseInt(pandigitalAsString.toString());
            if (Numbers.isPrime(possiblePandigitalNumber) && possiblePandigitalNumber > largestFoundPandigitalPrime) {
                largestFoundPandigitalPrime = possiblePandigitalNumber;
            }
        }

        return largestFoundPandigitalPrime;
    }

}
