package de.olilo.euler.level2;

import java.math.BigDecimal;

class Problem40ChampernownesConstant {

    public BigDecimal getConstantUntil(int n) {
        final StringBuilder constant = new StringBuilder("0.");
        for (int i = 1; i <= n; i++) {
            constant.append(i);
        }
        return new BigDecimal(constant.toString());
    }

    public int getDigitProduct(int base, int exp) {
        int result = 1;
        for (int i = 0; i <= exp; i++) {
            result *= getDigit((int) Math.pow(base, i));
        }
        return result;
    }

    public int getDigit(int n) {
        if (n < 10) {
            return n;
        }
        if (n < 10 + 2 * 90) {
            // two-digit numbers
            int number = 10 + (n - 10) / 2;
            return (n - 10) % 2 == 0 ? number / 10 : number % 10;
        }
        if (n < 10 + 2 * 90 + 3 * 900) {
            // three-digit numbers
            int number = 100 + (n - 10 - 2 * 90) / 3;
            switch ((n - 10 - 2 * 90) % 3) {
                case 0: return number / 100;
                case 1: return (number / 10) % 10;
                case 2: return number % 10;
            }
        }
        if (n < 10 + 2 * 90 + 3 * 900 + 4 * 9000) {
            // four-digit numbers
            int number = 1000 + (n - 10 - 2 * 90 - 3 * 900) / 4;
            switch ((n - 10 - 2 * 90 - 3 * 900) % 4) {
                case 0: return number / 1000;
                case 1: return (number / 100) % 10;
                case 2: return (number / 10) % 10;
                case 3: return number % 10;
            }
        }
        if (n < 10 + 2 * 90 + 3 * 900 + 4 * 9000 + 5 * 90_000) {
            // five-digit numbers
            int number = 10000 + (n - 10 - 2 * 90 - 3 * 900 - 4 * 9000) / 5;
            switch ((n - 10 - 2 * 90 - 3 * 900 - 4 * 9000) % 5) {
                case 0: return number / 10_000;
                case 1: return (number / 1000) % 10;
                case 2: return (number / 100) % 10;
                case 3: return (number / 10) % 10;
                case 4: return number % 10;
            }
        }
        if (n < 10 + 2 * 90 + 3 * 900 + 4 * 9000 + 5 * 90_000 + 6 * 900_000) {
            // six-digit numbers
            int number = 100000 + (n - 10 - 2 * 90 - 3 * 900 - 4 * 9000 - 5 * 90_000) / 6;
            switch ((n - 10 - 2 * 90 - 3 * 900 - 4 * 9000 - 5 * 90_000) % 6) {
                case 0: return number / 100_000;
                case 1: return (number / 10_000) % 10;
                case 2: return (number / 1000) % 10;
                case 3: return (number / 100) % 10;
                case 4: return (number / 10) % 10;
                case 5: return number % 10;
            }
        }
        if (n < 10 + 2 * 90 + 3 * 900 + 4 * 9000 + 5 * 90_000 + 6 * 900_000 + 7 * 9_000_000) {
            // seven-digit numbers
            int number = 1_000_000 + (n - 10 - 2 * 90 - 3 * 900 - 4 * 9000 - 5 * 90_000 - 6 * 900_000) / 7;
            switch ((n - 10 - 2 * 90 - 3 * 900 - 4 * 9000 - 5 * 90_000 - 6 * 900_000) % 7) {
                case 0: return number / 1_000_000;
                case 1: return (number / 100_000) % 10;
                case 2: return (number / 10_000) % 10;
                case 3: return (number / 1000) % 10;
                case 4: return (number / 100) % 10;
                case 5: return (number / 10) % 10;
                case 6: return number % 10;
            }
        }
        // TODO continue...
        return -1;
    }

}
