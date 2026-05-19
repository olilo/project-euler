package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

public class Problem38PandigitalMultiples implements Problem {

    @Override
    public String getMessage() {
        return "The largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product is: ";
    }

    @Override
    public int getProblemNumber() {
        return 38;
    }

    @Override
    public Number runProblem(Runner runner) {
        return getBiggestPandigitalProduct();
    }

    public long getBiggestPandigitalProduct() {
        long biggestPandigitalProduct = 0;
        for (int i = 1; i < 10000; i++) {
            int n = 1;
            long pandigitalProduct = 0;
            while (pandigitalProduct < 1_000_000_000) {
                pandigitalProduct = getConcatenatedProduct(i, n);
                if (pandigitalProduct > biggestPandigitalProduct && isPandigital(pandigitalProduct)) {
                    biggestPandigitalProduct = pandigitalProduct;
                }
                n++;
            }
        }
        return biggestPandigitalProduct;
    }

    public long getConcatenatedProduct(int number, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result.append(number * i);
        }
        return Long.parseLong(result.toString());
    }

    public boolean isPandigital(long number) {
        final String numberString = Long.toString(number);
        final int[] digits = new int[9];
        for (char c : numberString.toCharArray()) {
            if (c == '0') {
                return false;
            }
            digits[Character.getNumericValue(c) - 1] += 1;
        }
        for (int digitNum : digits) {
            if (digitNum != 1) {
                return false;
            }
        }
        return true;
    }

}
