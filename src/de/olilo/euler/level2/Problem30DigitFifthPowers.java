package de.olilo.euler.level2;

import java.util.ArrayList;
import java.util.List;

class Problem30DigitFifthPowers {

    public int getDigitFifthPowers(int number) {
        final String numberString = Integer.toString(number);
        int sum = 0;
        for (char digit : numberString.toCharArray()) {
            sum += Math.pow(new Integer(digit + ""), 5);
        }
        return sum;
    }

    public List<Integer> getNumbersEqualTheirDigitFifthPowers(int limit) {
        final List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i < limit; i++) {
            if (getDigitFifthPowers(i) == i) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    public int sumOf(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
