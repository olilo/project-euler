package de.olilo.euler.level1;

import de.olilo.util.Divisors;

class Problem12TriangularNumber {

    public long findFirstTriangularNumberWithNDivisors(int minimumDivisors) {
        // FIXME either find a minimum to go off from or find a purely algorithmic approach
        int index = 1;
        long number = 1;
        int numDivisors = 1;

        while (numDivisors < minimumDivisors) {
            index++;
            number += index;
            numDivisors = Divisors.of(number).length;
        }

        return number;
    }

}
