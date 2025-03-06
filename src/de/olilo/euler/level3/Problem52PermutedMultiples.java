package de.olilo.euler.level3;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem52PermutedMultiples implements Problem {
    @Override
    public String getMessage() {
        return "The smallest integer that is a permuted multiple of itself and 2x, 3x, 4x, 5x and 6x of itself is: ";
    }

    @Override
    public int getProblemNumber() {
        return 52;
    }

    @Override
    public Number runProblem(Runner runner) {
        for (int n = 1; true; n++) {
            final List<Integer> multiples = List.of(n, 2 * n, 3 * n, 4 * n, 5 * n, 6 * n);
            if (isPermutedMultiple(multiples)) {
                return n;
            }
        }
    }

    protected boolean isPermutedMultiple(List<Integer> numbers) {
        List<Integer> first = null;

        for (Integer number : numbers) {
            if (first == null) {
                first = convertIntegerToSortedDigits(number);
            } else if (!first.equals(convertIntegerToSortedDigits(number))) {
                return false;
            }
        }

        return true;
    }

    protected List<Integer> convertIntegerToSortedDigits(int number) {
        final List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        Collections.sort(digits);
        return digits;
    }
}
