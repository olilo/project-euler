package de.olilo.euler.level1;

import java.util.HashMap;
import java.util.Map;

class Problem17NumberLetterCounts {

    public static final int MILLION = 1000000;
    public static final int BILLION = 1000000000;

    private static Map<Integer, Integer> NUMBER_WORD_LENGTHS = new HashMap<Integer, Integer>();

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

        NUMBER_WORD_LENGTHS.put(100, "hundred".length());
        NUMBER_WORD_LENGTHS.put(1000, "thousand".length());
        NUMBER_WORD_LENGTHS.put(MILLION, "million".length());
        NUMBER_WORD_LENGTHS.put(BILLION, "billion".length());
    }

    public long countLettersInNumberWordsFrom1To(final int limit) {
        // brute force without cache for now
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            sum += getWordLengthOfNumber(i);
        }
        return sum;
    }

    long getWordLengthOfNumber(final int number) {
        if (number == 0) {
            return 0;
        } else if (number < 20) {
            return NUMBER_WORD_LENGTHS.get(number);
        } else if (number < 100) {
            final int lastDigit = number % 10;
            return NUMBER_WORD_LENGTHS.get(number - lastDigit) + getWordLengthOfNumber(lastDigit);
        } else if (number < 1000) {
            // first digit + "HUNDRED" + "AND" (3) + number for last two digits
            // e.g. three HUNDRED AND fifty-two
            final int firstDigit = number / 100;
            final int lastTwoDigits = number % 100;
            int result = NUMBER_WORD_LENGTHS.get(firstDigit) + NUMBER_WORD_LENGTHS.get(100);
            if (lastTwoDigits > 0) {
                result += 3 + getWordLengthOfNumber(lastTwoDigits);
            }
            return result;
        } else if (number < MILLION) {
            return getWordCountAfter1000(number, 1000);
        } else if (number < BILLION) {
            return getWordCountAfter1000(number, MILLION);
        } else {
            // we stop at billion because int can't go further
            return getWordCountAfter1000(number, BILLION);
        }
    }

    private long getWordCountAfter1000(int number, int divisor) {
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
