package de.olilo.euler.level1;

public class Problem6SumSquareDifference {

    public long getSumSquareDifference(int limit) {
        long sumOfSquares = 0;
        long squareOfSum = 0;
        for (int i = 1; i <= limit; i++) {
            sumOfSquares += i * i;
            squareOfSum += i;
        }
        squareOfSum = squareOfSum * squareOfSum;
        return squareOfSum - sumOfSquares;
    }

}
