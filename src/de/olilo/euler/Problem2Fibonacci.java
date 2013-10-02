package de.olilo.euler;

public class Problem2Fibonacci {

    public long solve(int max) {
        long sum = 0;
        long first = 1;
        long second = 1;
        while (second < max) {
            long next = first + second;
            first = second;
            second = next;
            if (next % 2 == 0) {
                sum += next;
            }
        }
        return sum;
    }

}
