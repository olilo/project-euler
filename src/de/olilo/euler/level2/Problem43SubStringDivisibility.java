package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Lists;
import de.olilo.util.PrimesIterable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem43SubStringDivisibility implements Problem {

    @Override
    public String getMessage() {
        return "The sum of all pandigital numbers (with 0 to 9) with sub-string divisibility" +
                "(e.g. 406 of 1406327289 is divisible by 2, 063 by 3, 635 by 5, 357 by 7 etc.) is: ";
    }

    @Override
    public int getProblemNumber() {
        return 43;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        long sum = 0;
        final List<List<Integer>> allPandigitals = Lists.generatePermutation(generateFirstPandigitalNumberIncludingZero());
        for (List<Integer> pandigital : allPandigitals) {
            if (isSubDivisible(pandigital)) {
                StringBuilder pandigitalNumber = new StringBuilder();
                for (Integer digit : pandigital) {
                    pandigitalNumber.append(digit);
                }
                sum += Long.parseLong(pandigitalNumber.toString());
            }
        }
        return sum;
    }

    protected List<Integer> generateFirstPandigitalNumberIncludingZero() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            digits.add(i);
        }
        return digits;
    }

    protected boolean isSubDivisible(List<Integer> numberAsDigits) {
        final Iterator<Integer> primesIterator = PrimesIterable.INSTANCE.iterator();
        for (int i = 1; i < numberAsDigits.size() - 2; i++) {
            String subString = String.valueOf(numberAsDigits.get(i)) + numberAsDigits.get(i + 1) + numberAsDigits.get(i + 2);
            int subNumber = Integer.parseInt(subString);
            if (subNumber % primesIterator.next() != 0) {
                return false;
            }
        }
        return true;
    }

}
