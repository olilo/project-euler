package de.olilo.euler.level2;

import java.util.ArrayList;
import java.util.List;

class Problem36DoubleBasePalindromes {

    public int sumOf(List<Integer> values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
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
        if (isPalindrome(Integer.toBinaryString(number))) {
            result.add(number);
        }
    }

    public boolean isPalindrome(String input) {
        final char[] chars = input.toCharArray();
        for (int i = 0; i < input.length() / 2; i++) {
            if (chars[i] != chars[input.length() - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

}
