package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Problem17NumberLetterCounts implements Problem {

    public static final int MILLION = 1_000_000;
    public static final int BILLION = 1_000_000_000;

    private static final Map<Integer, Integer> NUMBER_WORD_LENGTHS = new HashMap<>();

    static {
        NUMBER_WORD_LENGTHS.put(1, "ONE".length());
        NUMBER_WORD_LENGTHS.put(2, "TWO".length());
        NUMBER_WORD_LENGTHS.put(3, "THREE".length());
        NUMBER_WORD_LENGTHS.put(4, "FOUR".length());
        NUMBER_WORD_LENGTHS.put(5, "FIVE".length());
        NUMBER_WORD_LENGTHS.put(6, "SIX".length());
        NUMBER_WORD_LENGTHS.put(7, "SEVEN".length());
        NUMBER_WORD_LENGTHS.put(8, "EIGHT".length());
        NUMBER_WORD_LENGTHS.put(9, "NINE".length());

        NUMBER_WORD_LENGTHS.put(10, "TEN".length());
        NUMBER_WORD_LENGTHS.put(11, "ELEVEN".length());
        NUMBER_WORD_LENGTHS.put(12, "TWELVE".length());
        NUMBER_WORD_LENGTHS.put(13, "THIRTEEN".length());
        NUMBER_WORD_LENGTHS.put(14, "FOURTEEN".length());
        NUMBER_WORD_LENGTHS.put(15, "FIFTEEN".length());
        NUMBER_WORD_LENGTHS.put(16, "SIXTEEN".length());
        NUMBER_WORD_LENGTHS.put(17, "SEVENTEEN".length());
        NUMBER_WORD_LENGTHS.put(18, "EIGHTEEN".length());
        NUMBER_WORD_LENGTHS.put(19, "NINETEEN".length());

        NUMBER_WORD_LENGTHS.put(20, "TWENTY".length());
        NUMBER_WORD_LENGTHS.put(30, "THIRTY".length());
        NUMBER_WORD_LENGTHS.put(40, "FORTY".length());
        NUMBER_WORD_LENGTHS.put(50, "FIFTY".length());
        NUMBER_WORD_LENGTHS.put(60, "SIXTY".length());
        NUMBER_WORD_LENGTHS.put(70, "SEVENTY".length());
        NUMBER_WORD_LENGTHS.put(80, "EIGHTY".length());
        NUMBER_WORD_LENGTHS.put(90, "NINETY".length());

        NUMBER_WORD_LENGTHS.put(100, "HUNDRED".length());
        NUMBER_WORD_LENGTHS.put(1000, "THOUSAND".length());
        NUMBER_WORD_LENGTHS.put(MILLION, "MILLION".length());
        NUMBER_WORD_LENGTHS.put(BILLION, "BILLION".length());
    }

    @Override
    public String getMessage() {
        return "The letter count of all numbers from 1 to 1000 written out is: ";
    }

    @Override
    public int getProblemNumber() {
        return 17;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return countLettersInNumberWordsFrom1To(1000);
    }

    protected long countLettersInNumberWordsFrom1To(final int limit) {
        // brute force without cache for now
        long sum = 0;
        for (int i = 1; i <= limit; i++) {
            sum += getWordLengthOfNumber(i);
        }
        return sum;
    }

    protected long getWordLengthOfNumber(final int number) {
        if (number < 1000) {
            return getWordCountBelow1000(number);
        } else if (number < MILLION) {
            return getWordCountAbove1000(number, 1000);
        } else if (number < BILLION) {
            return getWordCountAbove1000(number, MILLION);
        } else {
            // we stop at billion because int can't go further
            return getWordCountAbove1000(number, BILLION);
        }
    }

    private long getWordCountBelow1000(int number) {
        if (number == 0) {
            return 0;
        } else if (number < 20) {
            return NUMBER_WORD_LENGTHS.get(number);
        } else if (number < 100) {
            final int lastDigit = number % 10;
            return NUMBER_WORD_LENGTHS.get(number - lastDigit) + getWordLengthOfNumber(lastDigit);
        } else {
            // first digit + "HUNDRED" + "AND" (3) + number for last two digits
            // e.g. three HUNDRED AND fifty-two
            final int firstDigit = number / 100;
            final int lastTwoDigits = number % 100;
            long result = NUMBER_WORD_LENGTHS.get(firstDigit) + NUMBER_WORD_LENGTHS.get(100);
            if (lastTwoDigits > 0) {
                result += 3 + getWordLengthOfNumber(lastTwoDigits);
            }
            return result;
        }
    }

    private long getWordCountAbove1000(int number, int divisor) {
        // we take thousand as example for the divisor
        // result is first part before thousands + "THOUSAND" + rest
        // e.g. fifty-two THOUSAND one hundred and forty-one
        final int firstThreeDigits = number / divisor;
        final int rest = number % divisor;
        return getWordLengthOfNumber(firstThreeDigits) +
                NUMBER_WORD_LENGTHS.get(divisor) +
                getWordLengthOfNumber(rest);
    }

}
