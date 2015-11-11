package de.olilo.euler.level1;

import java.math.BigInteger;

class Problem25FibonacciNumber {

    public int fibonacciIndexWithDigitCount(int digitCount) {
        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        int index = 1;
        while (current.toString().length() < digitCount) {
            BigInteger next = previous.add(current);
            previous = current;
            current = next;
            index++;
        }
        return index;
    }

}
