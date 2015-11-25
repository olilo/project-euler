package de.olilo.euler.level2;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

class Problem33DigitCancellingFractions {

    public Map.Entry<Integer, Integer> getProductOf(Map<Integer, Integer> values) {
        int numerator = 1;
        int denominator = 1;
        for (Map.Entry<Integer, Integer> valueEntry : values.entrySet()) {
            numerator *= valueEntry.getKey();
            denominator *= valueEntry.getValue();
        }
        double limit = Math.max(Math.sqrt(numerator), Math.sqrt(denominator));
        for (int i = 2; i < limit; i++) {
            while (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
            }
        }
        return new AbstractMap.SimpleEntry<>(numerator, denominator);
    }

    public Map<Integer, Integer> getDigitCancellingFractionsBetween(int start, int end) {
        final Map<Integer, Integer> result = new HashMap<>();
        for (int numerator = start; numerator <= end; numerator++) {
            for (int denominator = numerator + 1; denominator <= end; denominator++) {
                if (isDigitCancellingFraction(numerator, denominator)) {
                    result.put(numerator, denominator);
                }
            }
        }
        return result;
    }

    public boolean isDigitCancellingFraction(int numerator, int denominator) {
        final String numStr = Integer.toString(numerator);
        final String denStr = Integer.toString(denominator);
        for (char digit : numStr.toCharArray()) {
            if (digit == '0') {
                continue;
            }
            if (denStr.contains(digit + "")) {
                final String num2Str = numStr.replaceFirst(digit + "", "");
                final String den2Str = denStr.replaceFirst(digit + "", "");
                final double result = new Double(num2Str) / new Double(den2Str);
                if (Math.abs(result - ((double) numerator / (double) denominator)) < 0.000001) {
                    return true;
                }
            }
        }
        return false;
    }
}
