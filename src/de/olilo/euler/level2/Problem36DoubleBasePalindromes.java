package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Numbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Problem36DoubleBasePalindromes implements Problem {

    @Override
    public String getMessage() {
        return "The sum of all numbers, less than one million, which are palindromic in base 10 and base 2 is: ";
    }

    @Override
    public int getProblemNumber() {
        return 36;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return findPalindromesInBaseTenAndTwoUntil(1_000_000).stream().reduce(0, Integer::sum);
    }

    public List<Integer> findPalindromesInBaseTenAndTwoUntil(int limit) {
        final List<Integer> result = new ArrayList<>();
        int digits = 1;
        int counter = 1;
        int digitLimit = Integer.toString(limit).length();
        while (digits < digitLimit) {
            addIfPalindrome(result, digits, counter);

            counter++;
            if (counter >= Math.pow(10, (digits + 1) / 2.0) && digits % 2 == 1) {
                digits++;
                counter = (int) Math.pow(10, (digits - 1) / 2.0);
            }
            if (counter >= Math.pow(10, digits / 2.0) && digits % 2 == 0) {
                digits++;
            }
        }
        return result;
    }

    private void addIfPalindrome(List<Integer> result, int digits, int counter) {
        final String firstPart = Integer.toString(counter);
        final String secondPart = reverse(firstPart);
        int number;
        if (digits % 2 == 1) {
            number = Integer.parseInt(firstPart + secondPart.substring(1));
        } else {
            number = Integer.parseInt(firstPart + secondPart);
        }
        if (Numbers.isPalindrome(Integer.toBinaryString(number))) {
            result.add(number);
        }
    }

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

}
