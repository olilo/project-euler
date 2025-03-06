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
        return (int) probableTriangleNumber == probableTriangleNumber;
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

    public static boolean isHexagonalNumber(int n) {
        final double probableTriangleNumber = (Math.sqrt(8 * n + 1) + 1) / 4.0;
        return (int) probableTriangleNumber == probableTriangleNumber;
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

}
