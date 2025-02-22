package de.olilo.euler.level2;

class Problem38PandigitalMultiples {

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
