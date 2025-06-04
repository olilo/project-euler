package de.olilo.euler.level3;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Numbers;
import de.olilo.util.PrimesIterable;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Problem51PrimeDigitReplacements implements Problem {

    @Override
    public String getMessage() {
        return "The smallest prime with an eight prime family (e.g. 56003, 56113, 56333, 56443, 56663, 56773, and 56993 " +
                "is a seven prime family) is: ";
    }

    @Override
    public int getProblemNumber() {
        return 51;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        // FIXME we should have a more clever way to generate the base number (since we have many duplicates this way)
        for (int baseNumber : PrimesIterable.INSTANCE) {
            final String baseNumberAsString = String.valueOf(baseNumber);
            List<Collection<Integer>> digitsSetList = generateDigitSets(baseNumberAsString.length());
            digitsSetList = digitsSetList.stream().filter(digitsSet -> digitsSet.size() == 3 || digitsSet.size() >= 5).collect(Collectors.toList());
            for (Collection<Integer> digitsSet : digitsSetList) {
                if (getChainLengthFor(baseNumberAsString, digitsSet) >= 8) {
                    return replaceDigits(baseNumberAsString, digitsSet).get(0);
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
            if (Numbers.isPrime(number)) {
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
