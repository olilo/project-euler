package de.olilo.euler.level3;

import de.olilo.euler.Draft;
import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.PrimesIterable;

import java.io.IOException;
import java.util.*;

@Draft
public class Problem51PrimeDigitReplacements implements Problem {

    @Override
    public String getMessage() {
        return "The smallest prime ";
    }

    @Override
    public int getProblemNumber() {
        return 51;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        // FIXME we should have a more clever way to generate the base number (since we have many duplicates this way)
        for (int baseNumber = 10; baseNumber <= 1_000_000; baseNumber++) {
            final String baseNumberAsString = String.valueOf(baseNumber);
            for (Collection<Integer> digitsList : generateDigitSets(baseNumberAsString.length())) {
                if (getChainLengthFor(baseNumberAsString, digitsList) >= 8) {
                    return replaceDigits(baseNumberAsString, Set.copyOf(digitsList)).get(0);
                }
            }
        }
        return -1;
    }

    protected List<Collection<Integer>> generateDigitSets(int length) {
        return generateDigitSets(0, length, List.of());
    }

    protected List<Collection<Integer>> generateDigitSets(int current, int length, List<Collection<Integer>> chain) {
        if (current == length) {
            return chain;
        }

        List<Collection<Integer>> result = new ArrayList<>();
        for (Collection<Integer> digitSet : chain) {
            result.add(digitSet);
            Set<Integer> newSet = new HashSet<>(digitSet);
            newSet.add(current);
            result.add(newSet);
        }
        result.add(Set.of(current));

        return generateDigitSets(current + 1, length, result);
    }

    protected int getChainLengthFor(String baseNumber, Collection<Integer> digits) {
        int chainLength = 0;
        for (Integer number : replaceDigits(baseNumber, digits)) {
            if (PrimesIterable.INSTANCE.isPrime(number)) {
                chainLength++;
            }
        }
        return chainLength;
    }

    protected List<Integer> replaceDigits(String baseNumber, Collection<Integer> digits) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final StringBuilder newNumber = new StringBuilder();
            for (int j = 0; j < baseNumber.length(); j++) {
                if (digits.contains(j)) {
                    newNumber.append(i);
                } else {
                    newNumber.append(baseNumber.charAt(j));
                }
            }

            final String newNumberAsString = newNumber.toString();
            if (filterLeadingZeroes(newNumberAsString).length() == newNumberAsString.length()) {
                result.add(Integer.parseInt(newNumber.toString()));
            }
        }
        return result;
    }

    protected String filterLeadingZeroes(String number) {
        int n = 0;
        while (n < number.length() - 1 && number.charAt(n) == '0')  {
            n++;
        }
        return number.substring(n);
    }
}
