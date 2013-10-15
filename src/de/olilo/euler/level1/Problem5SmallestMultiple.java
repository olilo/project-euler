package de.olilo.euler.level1;

import java.math.BigInteger;

public class Problem5SmallestMultiple {

    public BigInteger findSmallestMultipleUpTo(int limit) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= limit; i++) {
            result = result.multiply(BigInteger.valueOf(i)).divide(result.gcd(BigInteger.valueOf(i)));
        }
        return result;
    }

}
