package de.olilo.util;

import java.math.BigInteger;

/**
 * TODO documentation
 */
public class Numbers {

    public static long getTriangleNumber(long n) {
        return n * (n + 1) / 2;
    }

    public static boolean isTriangleNumber(long n) {
        final double probableTriangleNumber = Math.sqrt(8 * n + 1);
        return (long) probableTriangleNumber == probableTriangleNumber;
    }

    public static boolean isTriangleNumber(BigInteger n) {
        final BigInteger innerNumber = n.multiply(BigInteger.valueOf(8)).add(BigInteger.ONE);
        final BigInteger[] root = innerNumber.sqrtAndRemainder();
        return root[1].equals(BigInteger.ZERO);
    }

    public static long getPentagonalNumber(long n) {
        return n * (3 * n - 1) / 2;
    }

    public static boolean isPentagonalNumber(long n) {
        final double probablePentagonalNumber = (Math.sqrt(24 * n + 1) + 1) / 6.0;
        return (long) probablePentagonalNumber == probablePentagonalNumber;
    }

    public static boolean isPentagonalNumber(BigInteger n) {
        final BigInteger innerNumber = n.multiply(BigInteger.valueOf(24)).add(BigInteger.ONE);
        final BigInteger[] root = innerNumber.sqrtAndRemainder();
        if (root[1].equals(BigInteger.ZERO)) {
            return root[0].add(BigInteger.ONE).mod(BigInteger.valueOf(6)).equals(BigInteger.ZERO);
        } else {
            return false;
        }
    }

    public static long getHexagonalNumber(long n) {
        return n * (2 * n - 1);
    }

    public static boolean isHexagonalNumber(long n) {
        final double probableTriangleNumber = (Math.sqrt(8 * n + 1) + 1) / 4.0;
        return (long) probableTriangleNumber == probableTriangleNumber;
    }

    public static boolean isHexagonalNumber(BigInteger n) {
        final BigInteger innerNumber = n.multiply(BigInteger.valueOf(8)).add(BigInteger.ONE);
        final BigInteger[] root = innerNumber.sqrtAndRemainder();
        if (root[1].equals(BigInteger.ZERO)) {
            return root[0].add(BigInteger.ONE).mod(BigInteger.valueOf(4)).equals(BigInteger.ZERO);
        } else {
            return false;
        }
    }

    public static boolean isPalindrome(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) < 0) return false;

        return n.equals(reverse(n));
    }

    public static BigInteger reverse(BigInteger n) {
        BigInteger reversed = BigInteger.ZERO;

        while (n.compareTo(BigInteger.ZERO) > 0) {
            reversed = reversed.multiply(BigInteger.TEN).add(n.mod(BigInteger.TEN));
            n = n.divide(BigInteger.TEN);
        }

        return reversed;
    }

    public static boolean isLychrelNumberBelowTenThousand(long n) {
        BigInteger current = BigInteger.valueOf(n);

        for (int i = 0; i < 50; i++) {
            current = current.add(reverse(current));

            if (isPalindrome(current)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(int n) {
        return PrimesIterable.INSTANCE.isPrime(n);
    }

    public static boolean isPrime(long n) {
        return PrimesIterable.INSTANCE.isPrime(n);
    }

    public static boolean isComposite(int n) {
        return !isPrime(n);
    }

    public static boolean isComposite(long n) {
        return !isPrime(n);
    }

}
