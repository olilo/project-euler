package de.olilo.util;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

public class NumbersTest {
    @Test
    public void testGetTriangleNumber() {
        final long expected = 28;
        final long actual = Numbers.getTriangleNumber(7);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetTriangleNumberBig() {
        final long expected = 50_000_005_000_000L;
        final long actual = Numbers.getTriangleNumber(10_000_000);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumberWith1() {
        final boolean expected = true;
        final boolean actual = Numbers.isTriangleNumber(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumberWithDevilsNumber() {
        final boolean expected = true;
        final boolean actual = Numbers.isTriangleNumber(666);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumber() {
        final boolean expected = true;
        final boolean actual = Numbers.isTriangleNumber(55);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumberFalse() {
        final boolean expected = false;
        final boolean actual = Numbers.isTriangleNumber(53);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumberBigInteger() {
        final boolean expected = true;
        final boolean actual = Numbers.isTriangleNumber(new BigInteger("30000000000000169058949593721"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumberBigInteger2() {
        final boolean expected = true;
        final boolean actual = Numbers.isTriangleNumber(new BigInteger("450000000000000000015000000000000000000"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumberBigIntegerFalse() {
        final boolean expected = false;
        final boolean actual = Numbers.isTriangleNumber(new BigInteger("45000000000000000001500000000000000"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumberBigIntegerRandom() {
        final Random random = new Random();
        final long randomTriangleNumber = Numbers.getTriangleNumber(random.nextInt(1_000_000));

        final boolean expected = true;
        final boolean actual = Numbers.isTriangleNumber(BigInteger.valueOf(randomTriangleNumber));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsTriangleNumberBigIntegerNumberLoop() {
        for (int n = 10; n < 1_000_000; n++) {
            final BigInteger toTest = BigInteger.valueOf(Numbers.getTriangleNumber(n) + 5);
            Assert.assertFalse(n + " is falsely recognized as a triangle number", Numbers.isTriangleNumber(toTest));
        }
    }

    @Test
    public void testGetPentagonalNumber() {
        final long expected = 22;
        final long actual = Numbers.getPentagonalNumber(4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPentagonalNumber2() {
        final long expected = 70;
        final long actual = Numbers.getPentagonalNumber(7);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPentagonalNumber() {
        final boolean expected = true;
        final boolean actual = Numbers.isPentagonalNumber(92);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPentagonalNumberBigNumber() {
        final boolean expected = true;
        final boolean actual = Numbers.isPentagonalNumber(3290);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPentagonalNumberFalse() {
        final boolean expected = false;
        final boolean actual = Numbers.isPentagonalNumber(95);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPentagonalNumberVeryBigFalse() {
        final boolean expected = false;
        final boolean actual = Numbers.isPentagonalNumber(567645);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPentagonalNumberBigInteger() {
        final boolean expected = true;
        final boolean actual = Numbers.isPentagonalNumber(new BigInteger("4499999999999997608761244777255"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPentagonalNumberBigIntegerFalse() {
        final boolean expected = false;
        final boolean actual = Numbers.isPentagonalNumber(new BigInteger("450000000000000000015000000000000"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPentagonalNumberBigIntegerRandom() {
        final Random random = new Random();
        final long randomPentagonalNumber = Numbers.getPentagonalNumber(random.nextInt(1_000_000));

        final boolean expected = true;
        final boolean actual = Numbers.isPentagonalNumber(BigInteger.valueOf(randomPentagonalNumber));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsPentagonalBigIntegerNumberLoop() {
        for (int n = 10; n < 1_000_000; n++) {
            final BigInteger toTest = BigInteger.valueOf(Numbers.getPentagonalNumber(n) + 5);
            Assert.assertFalse(n + " is falsely recognized as a pentagonal number", Numbers.isPentagonalNumber(toTest));
        }
    }

    @Test
    public void testGetHexagonalNumber() {
        final long expected = 45;
        final long actual = Numbers.getHexagonalNumber(5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHexagonalNumberBigger() {
        final long expected = 40755;
        final long actual = Numbers.getHexagonalNumber(143);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsHexagonalNumberWith1() {
        final boolean expected = true;
        final boolean actual = Numbers.isHexagonalNumber(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsHexagonalNumber() {
        final boolean expected = true;
        final boolean actual = Numbers.isHexagonalNumber(561);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsHexagonalNumberFalse() {
        final boolean expected = false;
        final boolean actual = Numbers.isHexagonalNumber(53);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsHexagonalNumberBigInteger() {
        final boolean expected = true;
        final boolean actual = Numbers.isHexagonalNumber(new BigInteger("1799999999999999999970000000000000000000"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsHexagonalNumberBigIntegerFalse() {
        final boolean expected = false;
        final boolean actual = Numbers.isHexagonalNumber(new BigInteger("450000000000000000015000000000000"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsHexagonalNumberBigIntegerRandom() {
        final Random random = new Random();
        final long randomHexagonalNumber = Numbers.getHexagonalNumber(random.nextInt(1_000_000));

        final boolean expected = true;
        final boolean actual = Numbers.isHexagonalNumber(BigInteger.valueOf(randomHexagonalNumber));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsHexagonalBigIntegerNumberLoop() {
        for (int n = 10; n < 1_000_000; n++) {
            final BigInteger toTest = BigInteger.valueOf(Numbers.getHexagonalNumber(n) + 5);
            Assert.assertFalse(n + " is falsely recognized as a pentagonal number", Numbers.isHexagonalNumber(toTest));
        }
    }

}
